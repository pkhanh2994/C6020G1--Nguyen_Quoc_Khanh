package com.codegym.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "borrow")
public class Borrow {
    @Id
    private Integer idBorrow;
    private Integer borrowCode;

    public Borrow() {
    }

    public Integer getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(Integer idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Integer getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(Integer borrowCode) {
        this.borrowCode = borrowCode;
    }
}
