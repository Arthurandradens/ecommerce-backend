package br.com.ecommerce.orders.model;

import br.com.ecommerce.orders.dto.ProductRequest;
import br.com.ecommerce.orders.dto.ProductUpdateRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Product(){}

    public Product(ProductRequest request,Category category) {
        this.name = request.name();
        this.description = request.description();
        this.price = request.price();
        this.category = category;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void update(ProductUpdateRequest request,Category category) {
        if (request.getName() != null) this.name = request.getName();
        if (request.getDescription() != null) this.description = request.getDescription();
        if (request.getPrice() != null) this.price = request.getPrice();
        if (category != null) this.category = category;
        this.updatedAt = LocalDateTime.now();
    }
}
