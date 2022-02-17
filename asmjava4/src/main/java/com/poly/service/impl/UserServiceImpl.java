package com.poly.service.impl;


import java.util.List;

import com.poly.dao.UserDao;
import com.poly.dao.impl.UserDaoImpl;
import com.poly.entity.User;
import com.poly.service.UserService;



public class UserServiceImpl  implements UserService{
	private UserDao dao;
	public UserServiceImpl() {
		dao= new  UserDaoImpl();
	}

	@Override
	public User findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User findByUsernam(String username) {
		return dao.findByUsernam(username);
		
		}

	@Override
	public User login(String username, String password) {
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User resetPassword(String email) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User create(String username, String password, String email) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setIsActive(Boolean.TRUE);
		newUser.setIsAdmin(Boolean.FALSE);;
		return dao.create(newUser);
	}

	@Override
	public User update(User entity) {
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		User user = dao.findByUsernam(username);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}

}
