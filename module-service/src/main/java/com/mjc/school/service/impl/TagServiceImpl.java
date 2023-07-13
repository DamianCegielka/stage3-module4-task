package com.mjc.school.service.impl;

import com.mjc.school.model.TagModel;
import com.mjc.school.repository.BaseRepository;
import com.mjc.school.service.TagService;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import com.mjc.school.service.exception.TagIsDoesNotExistException;
import com.mjc.school.service.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final BaseRepository<TagModel, Long> tagRepository;

    @Autowired
    public TagServiceImpl(BaseRepository<TagModel, Long> tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public List<TagDtoResponse> readAll() {
        return tagRepository.readAll().stream()
                .map(TagMapper.INSTANCE::tagModelToDto)
                .toList();
    }

    @Override
    public TagDtoResponse readById(Long id) {

        Optional<TagModel> tagModel = tagRepository.readById(id);
        if (tagModel.isPresent()) {
            return TagMapper.INSTANCE.tagModelToDto(tagModel.get());
        } else {
            throw new TagIsDoesNotExistException();
        }
    }

    @Override
    public TagDtoResponse create(TagDtoRequest createRequest) {
        TagModel tagModel = tagRepository.create(TagMapper.INSTANCE.tagDtoToModel(createRequest));
        return TagMapper.INSTANCE.tagModelToDto(tagModel);
    }

    @Override
    public TagDtoResponse update(TagDtoRequest updateRequest) {

        if (tagRepository.existById(updateRequest.getId())) {
            TagModel tagModel = tagRepository.update(TagMapper.INSTANCE.tagDtoToModel(updateRequest));
            return TagMapper.INSTANCE.tagModelToDto(tagModel);
        } else {
            throw new TagIsDoesNotExistException();
        }
    }

    @Override
    public boolean deleteById(Long id) {

        if (tagRepository.existById(id)) {
            return tagRepository.deleteById(id);
        } else {
            throw new TagIsDoesNotExistException();
        }
    }

    @Override
    public List<TagDtoResponse> readByNewsId(Long newsId) {
        return null;
    }

    @Override
    public List<TagDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy) {
        return null;
    }
}

