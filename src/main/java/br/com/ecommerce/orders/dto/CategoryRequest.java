package br.com.ecommerce.orders.dto;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank
        String name,
        Long parentId
) {
}
