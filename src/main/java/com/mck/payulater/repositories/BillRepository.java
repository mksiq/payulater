package com.mck.payulater.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mck.payulater.domain.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	
}
