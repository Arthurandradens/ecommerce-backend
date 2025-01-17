package br.com.ecommerce.orders.dto;

import jakarta.validation.constraints.NotNull;

public record OrderItemRequest(
        @NotNull
        Long productId,
        @NotNull
        Integer quantity
) {
}
