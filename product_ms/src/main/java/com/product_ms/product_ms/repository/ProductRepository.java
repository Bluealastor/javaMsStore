package com.product_ms.product_ms.repository;

import com.product_ms.product_ms.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
