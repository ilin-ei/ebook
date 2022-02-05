package ru.myprojects.ebook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="book_user", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> readers;
	
	public Book() {}

	public Book(String title, String author, List<User> readers) {
		this.title = title;
		this.author = author;
		this.readers = readers;
	}
	
	public Book(int id, String title, String author, List<User> readers) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.readers = readers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<User> getReaders() {
		return readers;
	}

	public void setReaders(List<User> readers) {
		this.readers = readers;
	}
}
