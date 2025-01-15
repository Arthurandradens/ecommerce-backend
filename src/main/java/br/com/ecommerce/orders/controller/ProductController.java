package br.com.ecommerce.orders.controller;

import br.com.ecommerce.orders.dto.ProductRequest;
import br.com.ecommerce.orders.dto.ProductResponse;
import br.com.ecommerce.orders.dto.ProductUpdateRequest;
import br.com.ecommerce.orders.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(Pageable pageable){
       Page<ProductResponse> products = service.getAllProducts(pageable);

       return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){

        ProductResponse product = service.createProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductUpdateRequest request){
        service.updateProduct(id,request);

        return ResponseEntity.noContent().build();
    }
}
