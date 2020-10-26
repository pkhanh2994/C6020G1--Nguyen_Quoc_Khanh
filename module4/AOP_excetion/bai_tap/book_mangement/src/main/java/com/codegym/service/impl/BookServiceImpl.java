package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.Borrow;
import com.codegym.repository.BookRepository;
import com.codegym.repository.BorrowRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired

    private BookRepository bookRepository;
    @Autowired
    private BorrowRepository borrowRepository;
    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void borrowBook(String idBook) throws Exception {
        Book book=this.bookRepository.findById(idBook).orElse(null);
        if(book.getQuantity()==0){
            throw new Exception("oh no, you can't read ???");
        }else {
            book.setQuantity(book.getQuantity()-1);
            Borrow borrow=new Borrow();
            borrow.setIdBorrow((int) (Math.random() * 10));
            borrow.setBorrowCode((int)(Math.random()*89999)+1000);
            this.borrowRepository.save(borrow);
        }

    }

    @Override
    public String giveBackBook(Integer idBorrow,String idBook) {
        List<Borrow> borrowList=this.borrowRepository.findAll();
        boolean checkCode=false;
        for(Borrow borrow:borrowList){
            if(idBorrow.equals(borrow.getBorrowCode())){
                checkCode=true;
                Book book=findById(idBook);
                book.setQuantity(book.getQuantity()+1);
                this.borrowRepository.delete(borrow);
            }
        }
        if(checkCode){
            return"You were give back book";
        }else {
            return "borrow code does not exits";
        }

    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> findByName(Pageable pageable, String bookName) {
        return this.bookRepository.findBookByBookNameContaining(pageable,bookName);
    }

    @Override
    public Book findById(String idBook) {
        return this.bookRepository.findById(idBook).orElse(null);
    }
}
