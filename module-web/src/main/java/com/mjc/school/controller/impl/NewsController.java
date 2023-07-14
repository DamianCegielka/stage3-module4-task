package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.news.NewsDtoRequest;
import com.mjc.school.service.dto.news.NewsDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController implements BaseController<NewsDtoRequest, NewsDtoResponse, Long> {

    @Autowired
    public final BaseService<NewsDtoRequest, NewsDtoResponse, Long> service;

    public NewsController(BaseService<NewsDtoRequest, NewsDtoResponse, Long> service) {
        this.service = service;
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        return service.create(createRequest);
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return service.readAll();
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        return service.readById(id);
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        return service.update(updateRequest);
    }

    @Override
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
