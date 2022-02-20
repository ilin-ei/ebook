package ru.myprojects.ebook.controller;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.myprojects.ebook.entity.Book;
import ru.myprojects.ebook.entity.User;
import ru.myprojects.ebook.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService theUserService) {
		userService = theUserService;
	}

	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		List<User> theUsers = userService.findAll();
		
		theModel.addAttribute("users", theUsers);
		
		return "users/list-of-users";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("username") String theUsername) {
		
		userService.delete(theUsername);
		
		return "redirect:/users/list";
	}
	
	@GetMapping("/myBooks")
	public String showMyBooks(@RequestParam("username") String theUsername, Model theModel) {
		
		User theUser = userService.findByUserName(theUsername);	
		Set<Book> myBooks = theUser.getBooks();
		theModel.addAttribute("books", myBooks);
		
		return "books/my-books";
	}
}
