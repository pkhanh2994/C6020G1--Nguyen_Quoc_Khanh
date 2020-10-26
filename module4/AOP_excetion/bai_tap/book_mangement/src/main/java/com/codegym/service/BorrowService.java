package com.codegym.service;

import com.codegym.entity.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow>findAll();
    Borrow saveBorrowList(Borrow borrow);
    Borrow findById(Integer id);
}
