package com.mjc.school.service.dto.news;

import lombok.Data;

@Data
public class NewsDtoRequest {

    Long id;
    String title;
    String content;
    Long authorId;

}