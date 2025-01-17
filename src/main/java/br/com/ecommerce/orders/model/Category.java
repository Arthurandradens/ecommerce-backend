package br.com.ecommerce.orders.model;

import br.com.ecommerce.orders.dto.CategoryRequest;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long parentId;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Category(CategoryRequest request) {
        this.name = request.name();
        this.parentId = request.parentId();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Category(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getParentId() {
        return parentId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
