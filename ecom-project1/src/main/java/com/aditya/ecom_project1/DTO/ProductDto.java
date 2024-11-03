package com.aditya.ecom_project1.DTO;

import lombok.*;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private String productName;
    private String description;
    private String brand;
    private String category;
    private BigDecimal price;
    private Boolean available;
    private int quantity;
    private String releaseDate; // Keep this as a String to accept formatted input

    // Getters and setters
}
