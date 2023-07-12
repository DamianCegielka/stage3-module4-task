package com.mjc.school.service.mapper;

import com.mjc.school.model.NewsModel;
import com.mjc.school.service.dto.news.NewsDtoResponse;
import org.mapstruct.Mapper;

@Mapper
public interface NewsModelMapperToDtoResponse {
    NewsDtoResponse map(NewsModel model);
}
