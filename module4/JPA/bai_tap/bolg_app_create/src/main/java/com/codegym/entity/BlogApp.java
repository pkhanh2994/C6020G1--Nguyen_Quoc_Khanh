package com.codegym.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "blog")
public class BlogApp {
    @Id
    private String id;
    private String blogName;
    private String blogContent;

    public BlogApp() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
