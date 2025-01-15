package br.com.ecommerce.orders.service;

import br.com.ecommerce.orders.dto.ProductRequest;
import br.com.ecommerce.orders.dto.ProductResponse;
import br.com.ecommerce.orders.dto.ProductUpdateRequest;
import br.com.ecommerce.orders.model.Category;
import br.com.ecommerce.orders.model.Product;
import br.com.ecommerce.orders.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    @Autowired
    CategoryService categoryService;

    public ProductResponse createProduct(ProductRequest request) {
        Category category = categoryService.getCategory(request.categoryId());

        Product product = new Product(request,category);
        repository.save(product);

        return new ProductResponse(product);
    }

    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable)
                .map(ProductResponse::new);
    }

    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("This Id do not exist"));
        Category category = categoryService.getCategory(request.getCategoryId());

        product.update(request,category);
        repository.save(product);
    }
}