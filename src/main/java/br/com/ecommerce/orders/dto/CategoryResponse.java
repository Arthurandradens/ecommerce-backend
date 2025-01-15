package br.com.ecommerce.orders.dto;

import br.com.ecommerce.orders.model.Category;

import java.time.LocalDateTime;

public record CategoryResponse(
        Long id,
        String name,
        Long parentId,
        LocalDateTime created_at,
        LocalDateTime updated_at
) {
    public CategoryResponse(Category category){
        this(
                category.getId(),
                category.getName(),
                category.getParentId(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }
}
