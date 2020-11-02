package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity(name = "blog")
public class BlogApp {
    @Id
    private String id;
    private String blogName;
    private String blogContent;
    private LocalDateTime timeDate;



    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "idCategory",referencedColumnName = "idCategory")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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


    public LocalDateTime getTimeDate() {
        return LocalDateTime.now();
    }

    public void setTimeDate(LocalDateTime timeDate) {
        this.timeDate = timeDate;
    }
}
