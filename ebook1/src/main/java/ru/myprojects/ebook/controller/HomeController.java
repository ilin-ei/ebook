package ru.myprojects.ebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	public HomeController() {}
	
	@GetMapping("/welcome")
	public String showHome() {
		
		return "home";
	}
}
