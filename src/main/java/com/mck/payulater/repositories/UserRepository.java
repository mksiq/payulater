package com.mck.payulater.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.mck.payulater.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
//	
//	@Transactional(readOnly=true)
//	@Query("SELECT obj FROM User obj INNER JOIN friends ON obj.id = friends.person_id WHERE obj.friends.friend_id = :objId")
//	List<User> findByFriendsId(@Param("objId") Integer friend_id);
}
