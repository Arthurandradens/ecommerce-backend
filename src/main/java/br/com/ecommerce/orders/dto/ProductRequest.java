package br.com.ecommerce.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        BigDecimal price,
        @NotNull
        Long categoryId
) {
}
