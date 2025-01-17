package br.com.ecommerce.orders.exception;

import java.time.LocalDateTime;

public record ErrorMessage(
        String error,
        String message,
        Integer status,
        LocalDateTime timestamp
){
}
