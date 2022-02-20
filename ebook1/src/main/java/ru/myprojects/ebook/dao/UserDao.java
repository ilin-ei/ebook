package ru.myprojects.ebook.dao;

import java.util.List;

import ru.myprojects.ebook.entity.Book;
import ru.myprojects.ebook.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
    public List<User> findAll();
    
    public void delete(String userName);
    
	public void addReader(User theUser, Book theBook);
	
}