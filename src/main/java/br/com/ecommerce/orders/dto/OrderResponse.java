package br.com.ecommerce.orders.dto;

import br.com.ecommerce.orders.model.Order;
import br.com.ecommerce.orders.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        BigDecimal total,
        OrderStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public OrderResponse(Order order) {
        this(
                order.getId(),
                order.getTotal(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }
}
