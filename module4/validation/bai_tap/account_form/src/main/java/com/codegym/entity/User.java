package com.codegym.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "user")
public class User{
    @Id
    @NotBlank
    private String idUser;
    @NotBlank
    @Size(min = 5,max = 45,message = "Name must be have 5-45 letter")
    private String firstName;
    @NotBlank
    @Size(min = 5,max = 45,message = "Name must be have 5-45 letter")
    private String lastName;
    @NotNull
    @Min(value = 18,message = "The age must be greater than 18")
    private Integer age;
    private String phoneNumber;
    @NotBlank
    @Email
    private String email;

    public User() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        User user=(User)target;
//        String phone=user.getPhoneNumber();
//        if(phone.equals("")){
//            errors.rejectValue("phoneNumber","phoneNumber.empty");
//        }else if(phone.length()>11||phoneNumber.length()<10){
//            errors.rejectValue("phoneNumber","phoneNumber.length");
//        }else if(!phone.startsWith("0")){
//            errors.rejectValue("phoneNumber","phoneNumber.startWith");
//        }else if(!phone.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("phoneNumber","phoneNumber.wrongForm");
//        }
//
//    }
}
