package com.sinarmas.crudapp.services;

import com.sinarmas.crudapp.dto.ProductInput;
import com.sinarmas.crudapp.dto.ResponseData;
import com.sinarmas.crudapp.models.Category;
import com.sinarmas.crudapp.models.Product;
import com.sinarmas.crudapp.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<ResponseData<List<Product>>> findAllProduct() {
        List<Product> data = productRepository.findAll();
        return ResponseEntity.ok(new ResponseData<>(data, true, "Data berhasil didapatkan"));
    }

    public ResponseEntity<ResponseData<Product>> findProductById(Integer id) {
        Product data = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product dengan id : " + id + " tidak ditemukan"));

        return ResponseEntity.ok(new ResponseData<>(data, true, "Data berhasil didaptkan"));
    }

    public ResponseEntity<ResponseData<Product>> saveProduct(ProductInput data) {
        Product product = productRepository.save(new Product(
                data.getName(),
                data.getPrice(),
                new Category(data.getCategory())
        ));

        return ResponseEntity.ok(new ResponseData<>(product, true, "Data berhasil disimpan"));
    }

    public ResponseEntity<ResponseData<Product>> updateProduct(ProductInput data, Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product dengan id : " + id + " tidak ditemukan"));

        product.setName(data.getName());
        product.setPrice(data.getPrice());
        product.setCategory(new Category(data.getCategory()));

        Product responseData = productRepository.save(product);

        return ResponseEntity.ok(new ResponseData<>(responseData, true, "Data berhasil diubah"));
    }

    public String deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product dengan id : " + id + " tidak ditemukan"));
        productRepository.delete(product);
        return "Data berhasil dihapus";
    }
}
