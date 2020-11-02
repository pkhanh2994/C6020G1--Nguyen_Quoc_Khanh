package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String categoryName;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<BlogApp>blogAppList;

    public List<BlogApp> getBlogAppList() {
        return blogAppList;
    }

    public void setBlogAppList(List<BlogApp> blogAppList) {
        this.blogAppList = blogAppList;
    }

    public Category() {
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer id) {
        this.idCategory = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
