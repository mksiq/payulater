package com.mck.payulater.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mck.payulater.domain.Category;
import com.mck.payulater.services.CategoryService;


@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/${id}",method=RequestMethod.GET)
	public ResponseEntity<?> list(@PathVariable Integer id) {
		
		Category obj = categoryService.find(id);
	
		return ResponseEntity.ok().body(obj);
	}
}
