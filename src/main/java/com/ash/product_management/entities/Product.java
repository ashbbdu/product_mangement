package com.ash.product_management.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products" , uniqueConstraints = {
        @UniqueConstraint(name = "sku_unique", columnNames = {"sku"}),
        @UniqueConstraint(name = "title_price_unique" , columnNames = {"title" , "price"})
},
 indexes = {
        @Index(name = "idx_sku" , columnList = "sku"),
        @Index(name = "idx_title_price" , columnList = "title , price")
 }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 20)
    private String sku;

    @Column(nullable = false , length = 100)
    private String title;


    private BigDecimal price;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

}
