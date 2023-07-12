package com.mjc.school.repository.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="comment")
@Data
public class CommentModel implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime modified;
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "NEWS_ID", referencedColumnName = "id")
    private NewsModel newsModel;
}
