package com.ash.product_management.controllers;

import com.ash.product_management.entities.ProductEntity;
import com.ash.product_management.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final int PAGE_SIZE = 10;

    @GetMapping("/list")
    public List<ProductEntity> getAllBySorting (@RequestParam(defaultValue = "id") String sortBy) {
//        Sort sort = Sort.by(sortBy).descending();
//        Sort sort = Sort.by("firstname").ascending()
//                .and(Sort.by("lastname").descending());
        Sort sort = Sort.by(Sort.Direction.DESC , sortBy , "price" , "title");
        return productRepository.findBy(sort);
    }

    @GetMapping("/list1")
    public Page<ProductEntity> getAllByPagination(@RequestParam(defaultValue = "id") String sortBy) {
//        pageable branch
//        Pageable pageable = Pageable.ofSize(1);
        Sort sort = Sort.by(Sort.Direction.ASC , sortBy);
        Pageable pageable = PageRequest.of(0 , PAGE_SIZE , sort);

        return productRepository.findAll(pageable);
    }
}
