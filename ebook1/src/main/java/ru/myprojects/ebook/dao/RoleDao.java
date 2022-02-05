package ru.myprojects.ebook.dao;

import ru.myprojects.ebook.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}