package br.com.ecommerce.orders.service;

import br.com.ecommerce.orders.dto.CategoryRequest;
import br.com.ecommerce.orders.dto.CategoryResponse;
import br.com.ecommerce.orders.model.Category;
import br.com.ecommerce.orders.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public CategoryResponse createCategory(CategoryRequest request){
        var category = new Category(request);
        repository.save(category);

        return new CategoryResponse(category);
    }

    public Page<CategoryResponse> getAllCategories(Pageable pageable) {
        return repository.findAll(pageable)
                .map(CategoryResponse::new);
    }

    public Category getCategory(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("This id do not exist"));
    }
}
