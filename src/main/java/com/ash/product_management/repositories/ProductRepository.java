package com.ash.product_management.repositories;

import com.ash.product_management.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity , Long> {
    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> readByTitle(String title);

    List<ProductEntity> findFirst2ByTitle(String title);

    List<ProductEntity> findByTitleStartingWith(String value);

    List<ProductEntity> findByTitleOrderByIdDesc(String title);

    List<ProductEntity> findDistinctByTitle(String title);

    ProductEntity findByTitleAndPrice(String title, BigDecimal price);

    @Query("select p from ProductEntity p where p.title =?1  and p.price=?2")
    ProductEntity findByTitleAndPrice1(String title, BigDecimal price);

    Long countByTitle(String title);

    List<ProductEntity> findBy(Sort sort);

    Page<ProductEntity> findAll(Pageable pageable);
}
