package com.mjc.school.service.impl;

import com.mjc.school.model.NewsModel;
import com.mjc.school.repository.NewsRepository;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.Validator;
import com.mjc.school.service.dto.news.NewsDtoRequest;
import com.mjc.school.service.dto.news.NewsDtoResponse;
import com.mjc.school.service.exception.NewsDoesNotExistException;
import com.mjc.school.service.mapper.NewsDtoRequestMapperToNewsModel;
import com.mjc.school.service.mapper.NewsModelMapperToDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {


    private final NewsRepository repository;
    private final NewsModelMapperToDtoResponse mapNewsModelToDtoResponse;
    private final NewsDtoRequestMapperToNewsModel mapNewsDtoRequestToNewsModel;
    private final Validator validator;


    @Override
    public List<NewsDtoResponse> readAll() {
        return repository
                .findAll()
                .stream()
                .map(mapNewsModelToDtoResponse::map)
                .toList();
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        return mapNewsModelToDtoResponse
                .map(repository
                        .findById(id)
                        .orElseThrow(() -> new NewsDoesNotExistException(id)));
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        try {
            validator.lengthBetween5And30Symbols(createRequest.getTitle());
            validator.lengthBetween5And255Symbols(createRequest.getContent());
            NewsModel newsModel = mapNewsDtoRequestToNewsModel.map(createRequest);
            return mapNewsModelToDtoResponse.map(repository.save(newsModel));
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        NewsModel newsModel = mapNewsDtoRequestToNewsModel.mapUpdate(updateRequest);
        return mapNewsModelToDtoResponse.map(repository.save(newsModel));
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Set<NewsDtoResponse> readNewsByVariousParameters(NewsDtoRequest newsRequestDto) {
        return null;
    }

    @Override
    public List<NewsDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy) {
        return null;
    }
}
