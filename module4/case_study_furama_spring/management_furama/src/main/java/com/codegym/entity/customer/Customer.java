package com.codegym.entity.customer;

import com.codegym.entity.contract.Contract;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "customer")
public class Customer {
    @Id
    @Pattern(regexp = "^KH" + "-" + "\\d{4}$",message = "The customer Id must be follow this form: KH-XXX. " +
            "X is the number from 0-9")
    private String customer_id;
    @NotBlank(message = "Please enter name")
    private String customer_name;
    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private String customer_birthday;
    private String customer_gender;
    @Pattern(regexp = "\\d{9}|\\d{12}",message = "The identify card must be have 9 number")
    private String customer_id_card;
    @Pattern(regexp = "^(09[0|1]|849[0|1])+\\d{7}$",message = "The phone number was wrong,please follow" +
            " this tutorial:090 or 0901 or 8490 " +
            "or 84911234567")
    private String customer_phone;
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$",message = "Email must be follow this " +
            "form: abc@abc.com")
    private String customer_email;
    private String customer_address;

    public Customer() {
    }
    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customer_type_id")
    private TypeOfCustomer typeOfCustomer;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract> contractList;

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public TypeOfCustomer getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(TypeOfCustomer typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(String customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_id_card() {
        return customer_id_card;
    }

    public void setCustomer_id_card(String customer_id_card) {
        this.customer_id_card = customer_id_card;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
}
