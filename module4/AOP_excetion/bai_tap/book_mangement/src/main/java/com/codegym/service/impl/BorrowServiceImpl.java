package com.codegym.service.impl;

import com.codegym.entity.Borrow;
import com.codegym.repository.BorrowRepository;
import com.codegym.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;
    @Override
    public List<Borrow> findAll() {
        return this.borrowRepository.findAll();
    }

    @Override
    public Borrow saveBorrowList(Borrow borrow) {
    return   this.borrowRepository.save(borrow);

    }

    @Override
    public Borrow findById(Integer id) {
        return this.borrowRepository.findById(id).orElse(null);
    }
}
