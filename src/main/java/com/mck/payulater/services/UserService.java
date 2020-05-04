package com.mck.payulater.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mck.payulater.domain.User;
import com.mck.payulater.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public User find(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<User> findAll() {
		
		return repo.findAll();
	}
	
//	public List<User> findByFriendsId(Integer friendsId) {
//		return repo.findByFriendsId(friendsId);
//	}
}
