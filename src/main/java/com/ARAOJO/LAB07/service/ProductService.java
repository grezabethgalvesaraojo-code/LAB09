// src/main/java/com/<your_lastname>/lab7/ProductService.java

package com.ARAOJO.LAB07.service;

import com.ARAOJO.LAB07.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service // Stereotype Annotation: Registers this as a business logic component [cite: 35]
public class ProductService {

    // Using Map to simulate database (fast lookup by ID) and for thread-safe operations
    private final Map<Long, Product> inventory = new ConcurrentHashMap<>();
    // Used to simulate an auto-incrementing primary key
    private final AtomicLong nextId = new AtomicLong(3);

    public ProductService() {
        // Initialize with at least three mock products [cite: 37]
        inventory.put(1L, new Product(1L, "Laptop Pro", 1299.99));
        inventory.put(2L, new Product(2L, "Wireless Mouse", 25.50));
        inventory.put(3L, new Product(3L, "USB-C Hub", 50.00));
    }

    // CREATE
    public Product createProduct(Product newProduct) {
        Long id = nextId.incrementAndGet(); // Assign a new, unique ID [cite: 65]
        newProduct.setId(id);
        inventory.put(id, newProduct);
        return newProduct;
    }

    // READ ALL
    public List<Product> findAll() {
        return new ArrayList<>(inventory.values());
    }

    // READ ONE
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(inventory.get(id));
    }

    // UPDATE
    public Optional<Product> updateProduct(Long id, Product productDetails) {
        if (inventory.containsKey(id)) {
            productDetails.setId(id); // Ensure the updated product retains the original ID
            inventory.put(id, productDetails);
            return Optional.of(productDetails);
        }
        return Optional.empty(); // Not found
    }

    // DELETE
    public boolean deleteProduct(Long id) {
        return inventory.remove(id) != null;
    }
}