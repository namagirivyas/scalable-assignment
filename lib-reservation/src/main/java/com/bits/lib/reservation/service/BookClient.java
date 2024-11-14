package com.bits.lib.reservation.service;

import com.bits.lib.reservation.entity.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "LIB-BOOKS")
public interface BookClient {

    @GetMapping("/api/books/{id}")
    Books getBookById(@PathVariable Long id);

    @GetMapping("/api/books")
    public List<Books> getAllBooks();
}
