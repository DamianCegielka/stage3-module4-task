package com.mjc.school.service.impl;

import com.mjc.school.model.TagModel;
import com.mjc.school.repository.TagRepository;
import com.mjc.school.service.TagService;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import com.mjc.school.service.exception.TagIsDoesNotExistException;
import com.mjc.school.service.mapper.TagMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<TagDtoResponse> readAll() {
        return tagRepository.findAll().stream()
                .map(TagMapper.INSTANCE::tagModelToDto)
                .toList();
    }

    @Override
    public TagDtoResponse readById(Long id) {

        Optional<TagModel> tagModel = tagRepository.findById(id);
        if (tagModel.isPresent()) {
            return TagMapper.INSTANCE.tagModelToDto(tagModel.get());
        } else {
            throw new TagIsDoesNotExistException();
        }
    }

    @Override
    public TagDtoResponse create(TagDtoRequest createRequest) {
        TagModel tagModel = tagRepository.save(TagMapper.INSTANCE.tagDtoToModel(createRequest));
        return TagMapper.INSTANCE.tagModelToDto(tagModel);
    }

    @Override
    public TagDtoResponse update(TagDtoRequest updateRequest) {

        if (tagRepository.existsById(updateRequest.getId())) {
            TagModel tagModel = tagRepository.save(TagMapper.INSTANCE.tagDtoToModel(updateRequest));
            return TagMapper.INSTANCE.tagModelToDto(tagModel);
        } else {
            throw new TagIsDoesNotExistException();
        }
    }

    @Override
    public boolean deleteById(Long id) {

        if (tagRepository.existsById(id)) {
            tagRepository.deleteById(id);
            return true;
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

