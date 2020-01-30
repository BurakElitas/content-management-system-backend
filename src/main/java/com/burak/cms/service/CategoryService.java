package com.burak.cms.service;

import com.burak.cms.entity.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);
    List<Category> getAllCategories();


}
