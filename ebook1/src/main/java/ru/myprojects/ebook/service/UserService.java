package ru.myprojects.ebook.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ru.myprojects.ebook.entity.Book;
import ru.myprojects.ebook.entity.User;
import ru.myprojects.ebook.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
	
    public List<User> findAll();
    
    public void delete(String userName);
    
	public void addReader(User theUser, Book theBook);
	
}
