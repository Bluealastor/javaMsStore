package com.inventory_ms.inventory_ms.repository;


import com.inventory_ms.inventory_ms.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {

    Optional<InventoryEntity> findBySkuCode(String sku_code);
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);

}
