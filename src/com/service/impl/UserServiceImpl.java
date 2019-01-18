package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.dao.UserDao;
import com.service.ServiceUser;

@Service
@Transactional
public class UserServiceImpl implements ServiceUser {
	@Resource
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return  userDao.findByName(name);
	}

}
