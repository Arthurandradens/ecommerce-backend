package br.com.ecommerce.orders.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        @NotNull
        BigDecimal total,
        @Valid
        @NotNull
        List<OrderItemRequest> items
) {
}
