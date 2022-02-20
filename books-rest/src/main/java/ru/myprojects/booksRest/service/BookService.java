package ru.myprojects.booksRest.service;

import java.util.List;

import ru.myprojects.booksRest.entity.Book;

public interface BookService {

	public List<Book> findAll();
	
	public Book findById(int theId);
	
	public void save(Book theBook);
	
	public void deleteById(int theId);
	
}
