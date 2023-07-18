package com.mjc.school.service.mapper;


import com.mjc.school.model.CommentModel;
import com.mjc.school.service.dto.comment.CommentDtoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CommentModelMapperToCommentDtoResponse {

    CommentDtoResponse map(CommentModel authorModel);

    List<CommentDtoResponse> mapList(List<CommentModel> commentModels);

}
