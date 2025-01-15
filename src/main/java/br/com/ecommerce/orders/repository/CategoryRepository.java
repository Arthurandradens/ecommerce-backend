package br.com.ecommerce.orders.repository;

import br.com.ecommerce.orders.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
