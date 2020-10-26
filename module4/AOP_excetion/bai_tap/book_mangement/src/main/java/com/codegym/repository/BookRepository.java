package com.codegym.repository;

import com.codegym.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,String> {

    Page<Book>findBookByBookNameContaining(Pageable pageable,String bookName);
}
