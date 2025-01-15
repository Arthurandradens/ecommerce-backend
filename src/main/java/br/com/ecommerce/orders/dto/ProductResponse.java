package br.com.ecommerce.orders.dto;

import br.com.ecommerce.orders.model.Product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        CategoryResponse category
) {
    public ProductResponse(Product product){
        this(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                new CategoryResponse(product.getCategory())
        );
    }
}
