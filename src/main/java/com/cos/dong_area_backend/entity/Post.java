package com.cos.dong_area_backend.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Post extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String context;

    private String writer;
    private String type;

    @Builder
    public Post(String title, String context, String writer, String type){
        this.title=title;
        this.context=context;
        this.writer=writer;
        this.type=type;
    }

}
