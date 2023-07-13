package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.model.AuthorModel;
import com.mjc.school.service.AuthorService;
import com.mjc.school.service.Validator;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import com.mjc.school.service.dto.author.AuthorDtoResponse;
import com.mjc.school.service.mapper.AuthorDtoRequestMapperToAuthorModel;
import com.mjc.school.service.mapper.AuthorModelMapperToAuthorDtoResponse;
import com.mjc.school.service.mapper.ModelDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    BaseRepository<AuthorModel, Long> repository;

    private AuthorModelMapperToAuthorDtoResponse mapAuthorModelToAuthorDtoResponse = new ModelDtoMapper.MapAuthorModelToAuthorDtoResponse();
    private AuthorDtoRequestMapperToAuthorModel mapAuthorDtoRequestToAuthorModel = new ModelDtoMapper.MapAuthorDtoRequestToAuthorModel();
    private Validator validator = new Validator();

    @Autowired
    public AuthorServiceImpl(BaseRepository<AuthorModel, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<AuthorDtoResponse> readAll() {
        List<AuthorDtoResponse> list = new ArrayList<>();
        repository.readAll().forEach(x -> list.add(mapAuthorModelToAuthorDtoResponse.map(x)));
        return list;
    }

    @Override
    public AuthorDtoResponse readById(Long id) {
        Optional<AuthorModel> authorDtoResponse = repository.readById(id);
        if (authorDtoResponse.isPresent()) {
            return mapAuthorModelToAuthorDtoResponse.map(authorDtoResponse.get());
        }
        return null;
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        try {
            validator.lengthBetween3And15Symbols(createRequest.getName());
            AuthorModel authorModel = mapAuthorDtoRequestToAuthorModel.map(createRequest);
            return mapAuthorModelToAuthorDtoResponse.map(repository.create(authorModel));
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        AuthorModel authorModel = mapAuthorDtoRequestToAuthorModel.mapUpdate(updateRequest);
        return mapAuthorModelToAuthorDtoResponse.map(repository.update(authorModel));
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public AuthorDtoResponse readByNewsId(Long newsId) {
        return null;
    }

    @Override
    public List<AuthorDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy) {
        return null;
    }
}
