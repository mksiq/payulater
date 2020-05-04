package com.mck.payulater.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mck.payulater.domain.Bill;
import com.mck.payulater.repositories.BillRepository;

@Service
public class BillService {
	@Autowired
	private BillRepository repo;
	
	public Bill find(Integer id) {
		Optional<Bill> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
