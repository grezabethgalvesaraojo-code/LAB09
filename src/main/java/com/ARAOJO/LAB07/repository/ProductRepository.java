package com.ARAOJO.LAB07.repository;

import com.ARAOJO.LAB07.model.Product;
import org.springframework.data.jpa.repository.JpaRepository; // [cite: 338]
import org.springframework.stereotype.Repository;

// The JpaRepository<T, ID> is parameterized by the Entity type (Product) and the ID type (Long). [cite: 341]
// This interface inherits all basic CRUD, sorting, and pagination methods. [cite: 336, 337]
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // You can also add Derived Query Methods here (e.g., List<Product> findByName(String name);) [cite: 321]
}