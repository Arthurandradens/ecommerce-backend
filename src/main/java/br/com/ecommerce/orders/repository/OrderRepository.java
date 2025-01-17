package br.com.ecommerce.orders.repository;

import br.com.ecommerce.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
