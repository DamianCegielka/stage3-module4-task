package com.mjc.school.controller.impl;


import com.mjc.school.controller.BaseController;
import com.mjc.school.service.TagService;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TagController implements BaseController<TagDtoRequest, TagDtoResponse, Long> {

    public final TagService service;

    @Override
    public TagDtoResponse create(TagDtoRequest createRequest) { return service.create(createRequest);}

    @Override
    public List<TagDtoResponse> readAll() { return service.readAll(); }

    @Override
    public TagDtoResponse readById(Long id) {
        return service.readById(id);
    }

    @Override
    public TagDtoResponse update(TagDtoRequest updateRequest) {
        return service.update(updateRequest);
    }

    @Override
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
