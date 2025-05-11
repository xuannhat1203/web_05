package com.baitap.session05.Modal;

public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private String publishDate;

    public Post() {
    }

    public Post(int id, String title, String content, String author, String publishDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
