package com.ARAOJO.LAB07;


package com.example.productinventory.service;
import com.example.productinventory.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Apply the @Service stereotype annotation
@Service
public class ProductService {

    // In-memory 'database' using Map<Long, Product> for quick lookups by ID
    private final Map<Long, Product> productRepo = new ConcurrentHashMap<>();

    // A simple counter to simulate auto-incrementing IDs for new products [cite: 65]
    private long nextId = 4L;

    // Constructor to initialize with mock data [cite: 37]
    public ProductService() {
        productRepo.put(1L, new Product(1L, "Laptop Pro", 1200.00));
        productRepo.put(2L, new Product(2L, "Wireless Mouse", 25.00));
        productRepo.put(3L, new Product(3L, "Mechanical Keyboard", 75.00));
    }

    // --- CRUD Operations ---

    /**
     * READ ALL Products: GET /api/products
     * @return A List of all products.
     */
    public List<Product> findAll() {
        // Return a new ArrayList containing all product values in the map
        return new ArrayList<>(productRepo.values());
    }

    /**
     * READ ONE Product: GET /api/products/{id}
     * @param id The unique identifier of the product[cite: 16].
     * @return The Product object if found, or null if it doesn't exist (for 404 handling).
     */
    public Product findById(long id) {
        // Map.get() is efficient for lookup and returns null if the key is not found
        return productRepo.get(id);
    }

    /**
     * CREATE a new Product: POST /api/products
     * @param newProduct The product data received from the request body[cite: 64].
     * @return The newly created product with the assigned ID.
     */
    public Product save(Product newProduct) {
        // 1. Assign a new, unique ID to the product [cite: 65]
        newProduct.setId(nextId);

        // 2. Store the product in the map
        productRepo.put(nextId, newProduct);

        // 3. Increment the counter for the next product
        nextId++;

        return newProduct;
    }

    /**
     * UPDATE an existing Product: PUT /api/products/{id}
     * @param id The ID from the path variable[cite: 69].
     * @param productDetails The updated data from the request body[cite: 69].
     * @return The updated Product if the ID exists, or null if not found (for 404 handling)[cite: 70, 71].
     */
    public Product update(long id, Product productDetails) {
        if (productRepo.containsKey(id)) {
            // Get the existing product
            Product existingProduct = productRepo.get(id);

            // Apply updates from the request body (ID is preserved)
            existingProduct.setName(productDetails.getName());
            existingProduct.setPrice(productDetails.getPrice());

            // The map entry is already updated since we modified the reference `existingProduct`
            return existingProduct;
        }
        // ID not found
        return null;
    }

    /**
     * DELETE a Product: DELETE /api/products/{id}
     * @param id The unique identifier of the product.
     * @return true if the product was successfully deleted, false if the ID was not found.
     */
    public boolean delete(long id) {
        // Map.remove(key) returns the value that was removed, or null if the key wasn't found.
        return productRepo.remove(id) != null;
    }
}