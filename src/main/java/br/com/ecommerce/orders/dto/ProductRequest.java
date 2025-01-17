package br.com.ecommerce.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "Field is required")
        String name,
        @NotBlank(message = "Field is required")
        String description,
        @NotNull(message = "Field is required")
        @Positive(message = "Price cannot contain negative value")
        BigDecimal price,
        @NotNull(message = "Field is required")
        Long categoryId
) {
}
