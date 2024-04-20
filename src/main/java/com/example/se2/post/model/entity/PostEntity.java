package com.example.se2.post.model.entity;

import com.example.se2.user.model.User;
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
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @Column(name = "createdAt")
    private LocalDate createdAt;
}
