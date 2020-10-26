package com.codegym.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "user")
public class User {
    @Id
    @Size(min=2,max=30,message = "nhap hoi ngu nha")
    @NotBlank(message ="ádsadasdsaasascffafads")
    private String name;
    @Min(value = 18,message = "nhap tren 18")
    private int age;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
