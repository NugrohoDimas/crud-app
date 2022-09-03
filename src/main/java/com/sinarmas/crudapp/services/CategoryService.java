package com.sinarmas.crudapp.services;

import com.sinarmas.crudapp.dto.CategoryInput;
import com.sinarmas.crudapp.dto.ResponseData;
import com.sinarmas.crudapp.models.Category;
import com.sinarmas.crudapp.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<ResponseData<List<Category>>> findAllCategory() {
        List<Category> data = categoryRepository.findAll();
        return ResponseEntity.ok(new ResponseData<>(data, true, "Data berhasil didapatkan"));
    }

    public ResponseEntity<ResponseData<Category>> findCategoryById(Integer id) {
        ResponseData<Category> responseData = new ResponseData<>();

        Category data = categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category dengan id : " + id + " tidak ditemukan"));

        responseData.setStatus(true);
        responseData.setMessage("Data berhasil didaptkan");
        responseData.setPayload(data);
        return ResponseEntity.ok(responseData);
    }

    public ResponseEntity<ResponseData<Category>> saveCategory(CategoryInput data) {
        Category payload = categoryRepository.save(new Category(data.getName()));
        return ResponseEntity.ok(new ResponseData<>(payload, true, "Berhasil menyimpan data"));
    }

    public ResponseEntity<ResponseData<Category>> updateCategory(CategoryInput data, Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category dengan id : " + id + " tidak ditemukan"));

        category.setName(data.getName());

        return ResponseEntity.ok(new ResponseData<>(category, true, "Berhasil mengubah data"));
    }

    public String deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category dengan id : " + id + " tidak ditemukan"));
        categoryRepository.delete(category);
        return "Data berhasil dihapus";
    }
}
