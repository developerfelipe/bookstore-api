package com.felipefreitas.BookstoreAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipefreitas.BookstoreAPI.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByReserved(boolean reserved);
	List<Book> findByTitleContaining(String title);
}
