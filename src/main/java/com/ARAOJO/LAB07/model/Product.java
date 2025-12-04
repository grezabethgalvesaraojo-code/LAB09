package com.ARAOJO.LAB07.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Import the JPA annotations
import jakarta.persistence.*; // [cite: 325]

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // 1. Marks this class as a JPA entity, representing a database table [cite: 351, 352]
@Table(name = "product") // 2. (Optional) Explicitly name the table if it differs from the class name [cite: 353, 356]
public class Product {

    @Id // 3. Designates this as the primary key field [cite: 360, 361]
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Generates ID using database's AUTO_INCREMENT [cite: 329, 362, 364]
    private Long id; // Unique identifier

    @Column(nullable = false) // 5. Ensures the column cannot be NULL in the database [cite: 365, 368]
    private String name; // Name of the product

    @Column(nullable = false) // Ensures the column cannot be NULL in the database
    private Double price; // Price of the product
}