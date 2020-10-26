package com.codegym.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "counter")
public class MyCounter {
    @Id
    private int count;

    public MyCounter() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int increment(){
        return count++;
    }
}
