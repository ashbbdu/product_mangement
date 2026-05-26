package com.ash.product_management.repositories;

import com.ash.product_management.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity , Long> {
    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> readByTitle(String title);

    List<ProductEntity> findFirst2ByTitle(String title);

    List<ProductEntity> findByTitleStartingWith(String value);

    List<ProductEntity> findByTitleOrderByIdDesc(String title);

    List<ProductEntity> findDistinctByTitle(String title);
}
