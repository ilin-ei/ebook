package ru.myprojects.ebook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.myprojects.ebook.dao.RoleDao;
import ru.myprojects.ebook.dao.UserDao;
import ru.myprojects.ebook.entity.Book;
import ru.myprojects.ebook.entity.Role;
import ru.myprojects.ebook.entity.User;
import ru.myprojects.ebook.user.CrmUser;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();

		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());

		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_member")));

		userDao.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public List<User> findAll() {

		return userDao.findAll();
	}

	@Override
	@Transactional
	public void delete(String userName) {
		userDao.delete(userName);
	}
	
	@Override
	@Transactional
	public void addReader(User theUser, Book theBook) {
		userDao.addReader(theUser, theBook);
	}
	
	@Override
	@Transactional
	public List<Book> showMyBooks(long theUserId) {
		return userDao.showMyBooks(theUserId);
	}
}
