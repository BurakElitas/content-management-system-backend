package com.burak.cms.controller;

import com.burak.cms.entity.Category;
import com.burak.cms.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Category>> allCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
}
