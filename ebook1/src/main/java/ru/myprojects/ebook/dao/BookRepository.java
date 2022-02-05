package ru.myprojects.ebook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.myprojects.ebook.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findAllByOrderByTitleAsc();
	
}
