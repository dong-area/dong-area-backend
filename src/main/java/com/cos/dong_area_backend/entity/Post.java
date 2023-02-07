package com.cos.dong_area_backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String context;

    private String writer;
    @CreatedDate
    private LocalDateTime createdDate;

    @Builder
    public Post(String title, String context, String writer){
        this.title=title;
        this.context=context;
        this.writer=writer;
    }

}
