package ru.myprojects.booksRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.myprojects.booksRest.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
