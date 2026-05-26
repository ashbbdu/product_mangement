package com.ash.product_management.controllers;

import com.ash.product_management.entities.ProductEntity;
import com.ash.product_management.repositories.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public List<ProductEntity> getAllBySorting () {
        Sort sort = Sort.by("id").descending();
        return productRepository.findBy(sort);
    }
}
