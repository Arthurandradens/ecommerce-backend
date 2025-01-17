package br.com.ecommerce.orders.dto;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank(message = "Field is required")
        String name,
        Long parentId
) {
}
