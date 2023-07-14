package com.mjc.school.controller.impl;


import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotations.CommandHandler;
import com.mjc.school.service.TagService;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class TagController implements BaseController<TagDtoRequest, TagDtoResponse, Long> {

    public final TagService service;

    @Override
    @CommandHandler(value = "createTag")
    public TagDtoResponse create(TagDtoRequest createRequest) { return service.create(createRequest);}

    @Override
    @CommandHandler(value = "readAllTag")
    public List<TagDtoResponse> readAll() { return service.readAll(); }

    @Override
    @CommandHandler(value = "readTag")
    public TagDtoResponse readById(Long id) {
        return service.readById(id);
    }

    @Override
    @CommandHandler(value = "updateTag")
    public TagDtoResponse update(TagDtoRequest updateRequest) {
        return service.update(updateRequest);
    }

    @Override
    @CommandHandler(value = "deleteTag")
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
