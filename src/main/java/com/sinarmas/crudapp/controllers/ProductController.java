package com.sinarmas.crudapp.controllers;

import com.sinarmas.crudapp.dto.ProductInput;
import com.sinarmas.crudapp.dto.ResponseData;
import com.sinarmas.crudapp.models.Product;
import com.sinarmas.crudapp.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ResponseData<List<Product>>> getAllProduct() {
        return productService.findAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Product>> getProductById(@PathVariable("id") Integer id) {
        return productService.findProductById(id);
    }

    @PostMapping()
    public ResponseEntity<ResponseData<Product>> addProduct(@Valid @RequestBody ProductInput data) {
        return productService.saveProduct(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Product>> updateProduct(@PathVariable("id") Integer id, @Valid @RequestBody ProductInput data) {
        return productService.updateProduct(data, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        return productService.deleteProduct(id);
    }
}
