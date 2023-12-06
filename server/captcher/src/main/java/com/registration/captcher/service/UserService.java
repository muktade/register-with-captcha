package com.registration.captcher.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.captcher.entiry.User;
import com.registration.captcher.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	
	public void createUser(User user) {

		repo.save(user);
	}

	public List<User> getAllUsers() {
		return repo.findAll();
	}

	public Optional<User> getOneUser(Long id) {
		return repo.findById(id);
	}
}
