package br.com.ecommerce.orders.controller;

import br.com.ecommerce.orders.dto.OrderRequest;
import br.com.ecommerce.orders.dto.OrderResponse;
import br.com.ecommerce.orders.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody OrderRequest request){
        OrderResponse order = service.createOrder(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
