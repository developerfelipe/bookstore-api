package com.felipefreitas.BookstoreAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipefreitas.BookstoreAPI.model.Book;
import com.felipefreitas.BookstoreAPI.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:8082")//CORS
@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title){
		
		try {
			List<Book> books = new ArrayList<Book>();
			
			//If no title given, search all. otherwise, search for title 
			if(title == null) {
				bookRepository.findAll().forEach(books::add);
			} else {
				bookRepository.findByTitleContaining(title).forEach(books::add);
			}
			
			// If No results on database
			if(books.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			// Return results 
			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> GetBookById(@PathVariable("id") long id){
		Optional<Book> bookInformation = bookRepository.findById(id);
		
		if(bookInformation.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(bookInformation.get(), HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		
		//If no ISBN Number is provided, The simple constructor will be used
		boolean simpleRegistration = book.getIsbnNumber() == null;
		
		try {
			
			Book _book;
			
			if(simpleRegistration) {
				_book = bookRepository.save(new Book(book.getTitle(), book.getAuthor()));
			} else {
				_book = bookRepository
						.save(new Book(book.getIsbnNumber(), 
									  book.getTitle(), 
									  book.getAuthor(), 
									  book.getPublisher(), 
									  book.getLaunchYear(),
									  book.getPageCount(),
									  book.getPrice(),
									  book.getBookFormat(),
									  book.getLanguage(),
									  book.getWeight(),
									  book.getGenre()));
			}
			return new ResponseEntity<>(_book, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book){
		
		Optional<Book> bookInformation = bookRepository.findById(id);
		
		if(bookInformation.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Book _book = bookInformation.get();
			_book.setIsbnNumber(book.getIsbnNumber());
			_book.setTitle(book.getTitle());
			_book.setAuthor(book.getAuthor());
			_book.setPublisher(book.getPublisher());
			_book.setLaunchYear(book.getLaunchYear());
			_book.setPageCount(book.getPageCount());
			_book.setPrice(book.getPrice());
			_book.setBookFormat(book.getBookFormat());
			_book.setLanguage(book.getLanguage());
			_book.setWeight(book.getWeight());
			_book.setGenre(book.getGenre());
			_book.setReserved(book.isReserved());
			
			return new ResponseEntity<>(bookRepository.save(_book), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable long id){
		try {
			bookRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/books/reserved")
	public ResponseEntity<List<Book>> findByReserved() {
		try {
			List<Book> books = bookRepository.findByReserved(true);
			
			if(books.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
