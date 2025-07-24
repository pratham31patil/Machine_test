package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Category;
import com.test.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService service;
	@GetMapping
	public Page<Category> getAll(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="5")int size){
		return service.getAll(PageRequest.of(page, size));
	}
	@GetMapping("/{id}")
	public Category get(@PathVariable Integer id) {
		return service.getById(id);
	}
	@PostMapping
	public Category create(@RequestBody Category category) {
		return service.save(category);
	}
	@PutMapping("/{id}")
    public Category update(@PathVariable Integer id,@RequestBody Category updated) {
    	return service.update(id, updated);
    }
	@DeleteMapping("/{id}")
		public void delete(@PathVariable Integer id) {
			service.delete(id);
		}
	}
	

