package com.example.se2.post.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    @Column(name = "content")
    private String content;
    @Column(name = "imageId")
    private Long imageId;
    @Column(name = "createdAt")
    private LocalDate createdAt;
    @Column(name = "heartNumber")
    private int heartNumber;
    @Column(name = "commentNumber")
    private int commentNumber;
}
