package com.mck.payulater.services;

import java.util.ArrayList;
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
//		User objUser = obj.orElse(null);
//		if(objUser.getFriendOf() != null) {
//			for(int i =0; i<objUser.getFriendOf().size();i++) {
//				objUser.getFriendOf().get(i).setFriendOf(null);
//			}
//		}
		return obj.orElse(null);
//		return objUser;
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public List<User> findByFriendsId(Integer friendsId) {
		List<User> list = repo.findByFriendsId(friendsId);
		if( list.size() > 0) {
			for(int i = 0; i < list.size(); i++) {
				list.get(i).setFriends(null);
			}			
		}
		return list;
	}
}
