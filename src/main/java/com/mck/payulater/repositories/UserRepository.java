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
	
	@Transactional(readOnly=true)
	
	//@Query(value = "SELECT * FROM auth_user ..." , nativeQuery=true)
//	@Query("SELECT u FROM User u INNER JOIN tbl_friends f ON User.id = f.personId WHERE f.friendId = :objId")
	@Query(value = "SELECT * FROM User u INNER JOIN tbl_friends f ON u.id = f.person_id WHERE f.friend_id = ?1", nativeQuery=true)
	List<User> findByFriendsId(Integer friend_id);
}
