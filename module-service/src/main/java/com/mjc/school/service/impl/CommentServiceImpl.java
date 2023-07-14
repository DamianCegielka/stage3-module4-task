package com.mjc.school.service.impl;

import com.mjc.school.service.CommentService;
import com.mjc.school.service.dto.comment.CommentDtoRequest;
import com.mjc.school.service.dto.comment.CommentDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public List<CommentDtoResponse> readAll() {
        return null;
    }

    @Override
    public CommentDtoResponse readById(Long id) {
        return null;
    }

    @Override
    public CommentDtoResponse create(CommentDtoRequest createRequest) {
        return null;
    }

    @Override
    public CommentDtoResponse update(CommentDtoRequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<CommentDtoResponse> readByNewsId(Long newsId) {
        return null;
    }

    @Override
    public List<CommentDtoResponse> readAllPagedAndSorted(int page, int size, String sortBy) {
        return null;
    }
}
