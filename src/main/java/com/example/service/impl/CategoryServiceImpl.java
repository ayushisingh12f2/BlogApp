package com.example.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.entities.Category;
import com.example.exceptions.ResourceNotFoundException;
import com.example.payloads.CategoryDto;
import com.example.service.CategoryService;
import com.example.repository.CategoryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category createdCategory = this.categoryRepository.save(category);
		return this.modelMapper.map(createdCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepository.save(category);
		
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id",categoryId));
		this.categoryRepository.delete(category);

	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> catList = this.categoryRepository.findAll();
		List<CategoryDto> list = catList.stream().map((category) -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id", categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

}
