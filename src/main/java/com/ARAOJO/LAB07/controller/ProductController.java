package com.ARAOJO.LAB07;

import com.ARAOJO.LAB07.model.Product;
import com.ARAOJO.LAB07.service.ProductService;

public class ProductController {
import com.ARAOJO.LAB.model.product;
import org.springframework.http.ResponseEntity;
import com.example.productinventory.model.Product;
import com.example.productinventory.service.ProductService;

    @RestController
    @RequestMapping("/api/products") // Base path for all endpoints in this controller
    public class ProductController {

        private final ProductService productService;

        // Constructor Injection
        public ProductController(ProductService productService) {
            this.productService = productService;
        }

        // --- Implement your API Endpoints here ---

        // 1. GET /api/products (To find all products)
        // @GetMapping

        // 2. GET /api/products/{id} (To find a product by ID)
        // @GetMapping("/{id}") - Handle 404 (Not Found)

        // 3. POST /api/products (To create a new product)
        @PostMapping
        public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
            // Implementation:
            // 1. Call productService.save(newProduct)
            // 2. Return a 201 Created status code with the saved product in the body
            // return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
            return null; // Replace with actual logic
        }

        // 4. PUT /api/products/{id} (To update an existing product)
        // @PutMapping("/{id}") - Handle 404

        // 5. DELETE /api/products/{id} (To delete a product)
        // @DeleteMapping("/{id}") - Handle 204 No Content for successful deletion
    }
}
