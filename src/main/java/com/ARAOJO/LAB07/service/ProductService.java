package com.ARAOJO.LAB07.service;

import com.ARAOJO.LAB07.model.Product;
// Import the newly created repository
import com.ARAOJO.LAB07.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // Inject the JPA Repository instead of the in-memory map
    private final ProductRepository productRepository;

    // Constructor Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE
    public Product createProduct(Product newProduct) {
        // JpaRepository's save() handles both CREATE (if ID is null) and UPDATE (if ID is set)
        return productRepository.save(newProduct);
    }

    // READ ALL
    public List<Product> findAll() {
        // findAll() returns all entities (List<Product>)
        return productRepository.findAll();
    }

    // READ ONE
    public Optional<Product> findById(Long id) {
        // findById() returns an Optional<Product>
        return productRepository.findById(id);
    }

    // UPDATE
    public Optional<Product> updateProduct(Long id, Product productDetails) {
        // 1. Check if the product exists
        return productRepository.findById(id)
                .map(existingProduct -> {
                    // 2. Update the fields of the managed entity
                    existingProduct.setName(productDetails.getName());
                    existingProduct.setPrice(productDetails.getPrice());
                    // 3. Save (will perform an UPDATE because the ID is set)
                    // If JPA Entity Lifecycle/Dirty Checking is active, this line might be optional within a @Transactional method [cite: 316, 317]
                    return productRepository.save(existingProduct);
                });
    }

    // DELETE
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}