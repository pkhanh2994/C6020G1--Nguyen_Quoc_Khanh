package com.codegym.service;

import com.codegym.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    void save(Book book);
    void borrowBook(String idBook) throws Exception;
    String giveBackBook(Integer idBorrow,String idBook);
    Page<Book>findAll(Pageable pageable);
    Page<Book>findByName(Pageable pageable,String bookName);
    Book findById(String idBook);

}
