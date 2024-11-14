package com.bits.lib.books.service;

import com.bits.lib.books.entity.Books;
import com.bits.lib.books.repo.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository bookRepository;

    public BooksService(BooksRepository booksRepository) {
        this.bookRepository = booksRepository;
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Books> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Books addBook(Books books) {
        return bookRepository.save(books);
    }

    public Books updateBook(Long id, Books updatedBooks) {
        Books books = bookRepository.findById(id).orElseThrow();
        books.setTitle(updatedBooks.getTitle());
        books.setAuthor(updatedBooks.getAuthor());
        books.setIsbn(updatedBooks.getIsbn());
        books.setAvailable(updatedBooks.isAvailable());
        return bookRepository.save(books);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}