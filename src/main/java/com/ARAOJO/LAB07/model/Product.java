// src/main/java/com/<your_lastname>/lab7/Product.java

package com.ARAOJO.LAB07.model  ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Combines @Getter, @Setter, @ToString, @EqualsAndHashCode
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a constructor with no arguments
public class Product {
    private Long id; // Unique identifier [cite: 16, 30]
    private String name; // Name of the product [cite: 16, 30]
    private Double price; // Price of the product [cite: 16, 30]
}