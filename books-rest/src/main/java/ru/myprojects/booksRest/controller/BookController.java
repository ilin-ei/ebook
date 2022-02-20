package ru.myprojects.booksRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.myprojects.booksRest.entity.Book;
import ru.myprojects.booksRest.service.BookService;

@RestController
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService theBookService) {
		bookService = theBookService;
	}
	
	@GetMapping("/books")
	public List<Book> findAll() {
		return bookService.findAll();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable int bookId){
			
		return bookService.findById(bookId);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book theBook) {
	
		theBook.setId(0);
		bookService.save(theBook);
		return theBook;
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book theBook) {
	
		bookService.save(theBook);
		return theBook;
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		
		bookService.deleteById(bookId);
		
		return "Book with id = " + bookId + " deleted" ;
	}
	
}
