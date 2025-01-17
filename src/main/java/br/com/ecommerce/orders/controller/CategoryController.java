package br.com.ecommerce.orders.controller;

import br.com.ecommerce.orders.dto.CategoryRequest;
import br.com.ecommerce.orders.dto.CategoryResponse;
import br.com.ecommerce.orders.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getAll(Pageable pageable){
        Page<CategoryResponse> categories =  service.getAllCategories(pageable);

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest request){
        var category = service.createCategory(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
