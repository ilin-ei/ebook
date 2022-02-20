package ru.myprojects.booksRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.myprojects.booksRest.dao.BookRepository;
import ru.myprojects.booksRest.entity.Book;

@Service
public class BookServiceImpl implements BookService{
	
		private BookRepository bookRepository;
		
		@Autowired
		public BookServiceImpl(BookRepository theBookRepository) {
			bookRepository = theBookRepository;
		}
		
		@Override
		public List<Book> findAll() {
			return bookRepository.findAll();
		}

		@Override
		public Book findById(int theId) {
			Optional<Book> result = bookRepository.findById(theId);
			
			Book theBook = null;
			
			if (result.isPresent()) {
				theBook = result.get();
			}
			else {
				throw new RuntimeException("Did not find book id - " + theId);
			}
			
			return theBook;
		}

		@Override
		public void save(Book theBook) {
			List<Book> books = bookRepository.findAll();
			int i=0;
			for(Book b: books) {
				
				if (b.getTitle().equals(theBook.getTitle()) & b.getAuthor().equals(theBook.getAuthor())) {
					i++;
					System.out.println("The book is already in the database");
				}
			}
			if (i == 0) {
			bookRepository.save(theBook);
			}
		}

		@Override
		public void deleteById(int theId) {
			bookRepository.deleteById(theId);
		}
	}
