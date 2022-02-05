package ru.myprojects.ebook.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.myprojects.ebook.entity.Book;
import ru.myprojects.ebook.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User findByUserName(String theUserName) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public List<User> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		List<User> theUsers = currentSession.createQuery("from User", User.class).getResultList();
				
		return theUsers;
	}

	@Override
	public void delete(String userName) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from User where userName=:uName");
		theQuery.setParameter("uName", userName);
		theQuery.executeUpdate();
	}
	
	@Override
	public void addReader(User theUser, Book theBook) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		theUser.getBooks().add(theBook);
		currentSession.saveOrUpdate(theUser);
	}
	
	@Override
	public List<Book> showMyBooks(long theUserId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Book> theQuery = currentSession.createQuery("from User u right join Book_user bu on u.id=bu.user_id"
				+ " where u.id=:uId", Book.class);
		List <Book> myBooks = theQuery.setParameter("uId", theUserId).getResultList();
		
		return myBooks;
	}
}
