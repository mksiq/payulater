package com.mck.payulater.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mck.payulater.domain.User;
import com.mck.payulater.services.UserService;


@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		User obj = service.find(id);
	
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/complete/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findComplete(@PathVariable Integer id) {
		User obj = service.find(id);
		List<User> friends = service.findAll();
		obj.getFriends().addAll(friends);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
//	@RequestMapping(value="/friends/{id}",method=RequestMethod.GET)
//	public ResponseEntity<?> findAll(@PathVariable Integer id) {
//		User obj = service.find(id);
//		List<User> friends = service.findByFriendsId(id);
//		obj.getFriends().addAll(friends);
//		return ResponseEntity.ok().body(obj);
//	}
	
}