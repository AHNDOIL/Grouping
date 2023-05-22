package com.AHNDOIL.Grouping.dto;

import java.util.List;

public class PostDto {


    private Long id;
    private String title;
    private String content;
    private String restaurant;
    private String location;
    private Long memberCount;
    private UserDto author;
    private List<CommentDto> comments;


    public PostDto() {
    }

    public PostDto(Long id, String title, String content, String restaurant, String location, Long memberCount, UserDto author, List<CommentDto> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
        this.location = location;
        this.memberCount = memberCount;
        this.author = author;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Long memberCount) {
        this.memberCount = memberCount;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", location='" + location + '\'' +
                ", memberCount=" + memberCount +
                ", author=" + author +
                ", comments=" + comments +
                '}';
    }
}
