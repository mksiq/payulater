package com.mck.payulater.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mck.payulater.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
