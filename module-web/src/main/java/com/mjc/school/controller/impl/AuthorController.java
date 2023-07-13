package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotations.CommandHandler;
import com.mjc.school.service.AuthorService;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import com.mjc.school.service.dto.author.AuthorDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AuthorController implements BaseController<AuthorDtoRequest, AuthorDtoResponse, Long>{

  private final AuthorService service;

    @Override
    @CommandHandler(value = "readAllAuthors")
    public List<AuthorDtoResponse> readAll() {
        return service.readAll();
    }

    @Override
    @CommandHandler(value = "readAuthor")
    public AuthorDtoResponse readById(Long id) { return service.readById(id); }

    @Override
    @CommandHandler(value = "createAuthor")
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) { return service.create(createRequest); }

    @Override
    @CommandHandler(value = "updateAuthor")
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        return service.update(updateRequest);
    }

    @Override
    @CommandHandler(value = "deleteAuthor")
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
