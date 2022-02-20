package ru.myprojects.ebook.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReadBookController {

@GetMapping("/read")
public String read(@RequestParam("title") String theTitle, @RequestParam("author") String theAuthor,
		Model theModel) throws IOException {
	
	String title = theTitle;
	String choice = String.format("src/main/resources/books/%s.txt", title);

	    try(BufferedReader reader = new BufferedReader(new FileReader(choice))){
	    	String line;
	    	StringBuilder result = new StringBuilder();
	    	while((line = reader.readLine()) != null) {
	    		result.append(line).append("\n");
	    	}
	    	theModel.addAttribute("text", result);
	    	theModel.addAttribute("title", theTitle);
	    	theModel.addAttribute("author", theAuthor);
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	return "books/text-of-book";
	}
}
