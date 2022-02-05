package ru.myprojects.ebook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.myprojects.ebook.entity.Book;
import ru.myprojects.ebook.entity.User;
import ru.myprojects.ebook.service.BookService;
import ru.myprojects.ebook.service.UserService;

@Controller
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	private UserService userService;
	
	public BookController(BookService theBookService, UserService theUserService) {
		bookService = theBookService;
		userService = theUserService;
	}

	@GetMapping("/list")
	public String listBooks(Model theModel) {
		
		List<Book> theBooks = bookService.findAll();
		theModel.addAttribute("books", theBooks);
		
		return "books/list-of-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		return "books/book-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId,
									Model theModel) {
		
		Book theBook = bookService.findById(theId);
		
		theModel.addAttribute("book", theBook);
				
		return "books/book-form";			
	}
		
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book theBook) {
		
		int bookId = theBook.getId();
		if(bookId == 0) {
			bookService.save(theBook);
			
			return "redirect:/books/list";
		}
		else {
		
		Book oldBook = bookService.findById(bookId);
		List<User> readers = oldBook.getReaders();
//		for(User r: readers) {
//			System.out.println(r);
//		}
//		System.out.println(bookId);
		
		theBook.setReaders(readers);
		bookService.save(theBook);
		
		return "redirect:/books/list";
		}
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {
		
		bookService.deleteById(theId);
		
		return "redirect:/books/list";
	}
	
	@GetMapping("/addBook")
	public String addBook(@RequestParam("bookId") int bookId, @RequestParam("username") String username, Model theModel) {
		User theUser = userService.findByUserName(username);
		Book theBook = bookService.findById(bookId);
		userService.addReader(theUser, theBook);

		return "books/book-added";
	}
	
	@GetMapping("/deleteFromMyBooks")
	public String deleteFromMyBooks(@RequestParam("bookId") int bookId, @RequestParam("username") String username, Model theModel) {
				
		return "books/book-deleted";
	}
}
