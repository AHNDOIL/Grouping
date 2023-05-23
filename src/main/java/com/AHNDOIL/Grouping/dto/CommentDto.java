package com.AHNDOIL.Grouping.dto;

import com.AHNDOIL.Grouping.entity.PostEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;

public class CommentDto {

    private Long id;
    private String content;
    private UserEntity author;
    private PostEntity post;

    public CommentDto() {
    }

    public CommentDto(Long id, String content, UserEntity author, PostEntity post) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", post=" + post +
                '}';
    }
}
