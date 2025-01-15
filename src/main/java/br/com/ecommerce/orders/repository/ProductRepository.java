package br.com.ecommerce.orders.repository;

import br.com.ecommerce.orders.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
