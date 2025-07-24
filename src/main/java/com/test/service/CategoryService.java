package com.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.entity.Category;
import com.test.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	public Page<Category> getAll(Pageable pageable){
		return categoryRepository.findAll(pageable);
	}
	public Category getById(Integer id) {
		return categoryRepository.findById(id).orElseThrow();
	}
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	public Category update(Integer id,Category updated) {
		Category c=getById(id);
		c.setName(updated.getName());
		return categoryRepository.save(c);
	}
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}

}
