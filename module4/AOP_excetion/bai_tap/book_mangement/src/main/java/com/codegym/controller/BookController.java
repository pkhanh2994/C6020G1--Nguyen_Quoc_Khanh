package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.entity.Borrow;
import com.codegym.service.BookService;
import com.codegym.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;

    @GetMapping("/")
    public String homePage(Model model, @PageableDefault(size = 2) Pageable pageable, Optional<String> keyword) {
        String holdKeyword = "";
        if (keyword.isPresent()) {
            holdKeyword = keyword.get();
            model.addAttribute("bookList", this.bookService.findByName(pageable, holdKeyword));
        } else {
            model.addAttribute("bookList", this.bookService.findAll(pageable));
        }
        model.addAttribute("holdKeyword", holdKeyword);
        return "home-page";
    }

    @GetMapping("create")
    public String formCreate(Model model, Book book) {
        model.addAttribute("book", book);
        return "create";
    }

    @PostMapping("create")
    public String createBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        this.bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "created new information about book");
        return "redirect:/";

    }

    @GetMapping("{idBook}/detailsBook")
    public String detailsBook(@PathVariable String idBook, Model model) {
        Book book = this.bookService.findById(idBook);
        model.addAttribute("book", book);
        return "details";

    }

    @PostMapping("borrow")
    public String borrowBook(@RequestParam String idBook,Model model) throws Exception {
    this.bookService.borrowBook(idBook);
    return  "home-page";
    }

    @GetMapping("giveBack")
    public String giveBackForm(Model model, @PathVariable String idBook) {
        Book book = this.bookService.findById(idBook);
        model.addAttribute("book", book);
        return "give-back";
    }

    @PostMapping("giveBack")
    public String giveBackBook(@RequestParam String idBook, @RequestParam Integer codeBorrow ,RedirectAttributes redirectAttributes)  {
        this.bookService.giveBackBook(codeBorrow,idBook);
        redirectAttributes.addFlashAttribute("message", "give back book");
        return "redirect:/";
    }
}
