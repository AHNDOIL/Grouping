package com.AHNDOIL.Grouping.dto;

public class CommentDto {

    private Long id;
    private String content;
    private UserDto author;
    private PostDto post;

    public CommentDto() {
    }

    public CommentDto(Long id, String content, UserDto author, PostDto post) {
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

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public PostDto getPost() {
        return post;
    }

    public void setPost(PostDto post) {
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
