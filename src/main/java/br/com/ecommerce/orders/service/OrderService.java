package br.com.ecommerce.orders.service;

import br.com.ecommerce.orders.dto.OrderRequest;
import br.com.ecommerce.orders.dto.OrderResponse;
import br.com.ecommerce.orders.model.Order;
import br.com.ecommerce.orders.model.OrderItem;
import br.com.ecommerce.orders.model.Product;
import br.com.ecommerce.orders.repository.OrderItemRepository;
import br.com.ecommerce.orders.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;
    @Autowired
    OrderItemRepository itemRepository;
    @Autowired
    ProductService productService;

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
            Order order = new Order();

            List<OrderItem> itemList = request.items().stream()
                    .map(i -> OrderItem.of(i,order,productService.getProduct(i.productId())))
                    .toList();

        BigDecimal total = itemList.stream()
                        .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                        .reduce(BigDecimal.ZERO,BigDecimal::add);

        order.setItems(itemList);
        order.setTotal(total);


        repository.save(order);

        return new OrderResponse(order);
    }
}
