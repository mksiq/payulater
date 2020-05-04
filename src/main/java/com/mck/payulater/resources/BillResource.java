package com.mck.payulater.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mck.payulater.domain.Bill;
import com.mck.payulater.services.BillService;


@RestController
@RequestMapping(value="/bills")
public class BillResource {

	@Autowired
	private BillService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Bill obj = service.find(id);	
		return ResponseEntity.ok().body(obj);
	}
}
