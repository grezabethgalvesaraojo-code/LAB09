package com.ARAOJO.LAB07;

public class Product {
    // src/main/java/com/example/productinventory/model/Product.java (Example structure)
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Product {
        private long id;
        private String name;
        private double price;
    }
}
