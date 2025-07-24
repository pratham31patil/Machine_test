package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.entity.Product;
import com.test.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
 private ProductRepository productRepository;
 public Page<Product> getAll(Pageable pageable){
	 return productRepository.findAll(pageable);
 }
 public Product getById(Integer id) {
	 return productRepository.findById(id).orElseThrow();
 }
 public Product save(Product product) {
	 return productRepository.save(product);
 }
 public Product update(Integer id,Product updated) {
	 Product p=getById(id);
	 p.setName(updated.getName());
	 p.setPrice(updated.getPrice());
	 p.setCategory(updated.getCategory());
	 return productRepository.save(p);
 }
 public void delete(Integer id) {
	 productRepository.deleteById(id);
 }
}
