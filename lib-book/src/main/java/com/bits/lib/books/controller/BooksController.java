package com.bits.lib.books.controller;

import com.bits.lib.books.entity.Books;
import com.bits.lib.books.service.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BooksService bookService;

    public BooksController(BooksService booksService) {
        this.bookService = booksService;
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Books getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElseThrow();
    }

    @PostMapping
    public Books addBook(@RequestBody Books books) {
        return bookService.addBook(books);
    }

    @PutMapping("/{id}")
    public Books updateBook(@PathVariable Long id, @RequestBody Books books) {
        return bookService.updateBook(id, books);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}