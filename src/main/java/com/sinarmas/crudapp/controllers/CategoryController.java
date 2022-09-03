package com.sinarmas.crudapp.controllers;

import com.sinarmas.crudapp.dto.CategoryInput;
import com.sinarmas.crudapp.dto.ResponseData;
import com.sinarmas.crudapp.models.Category;
import com.sinarmas.crudapp.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<ResponseData<List<Category>>> getAllCategory() {
        return categoryService.findAllCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Category>> getCategoryById(@PathVariable("id") Integer id) {
        return categoryService.findCategoryById(id);
    }

    @PostMapping()
    public ResponseEntity<ResponseData<Category>> addCategory(@Valid @RequestBody CategoryInput data) {
        return categoryService.saveCategory(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Category>> updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryInput data) {
        return categoryService.updateCategory(data, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        return categoryService.deleteCategory(id);
    }
}
