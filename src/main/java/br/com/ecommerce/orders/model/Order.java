package br.com.ecommerce.orders.model;

import br.com.ecommerce.orders.dto.OrderItemRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal total;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    @OneToMany(cascade = CascadeType.ALL)
    List<OrderItem> items;


    public Order(){
        this.total = new BigDecimal(0);
        this.status = OrderStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;

    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
