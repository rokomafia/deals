package com.deals.service;

import com.deals.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
