package com.bits.lib.books.repo;

import com.bits.lib.books.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
