package com.inventory_ms.inventory_ms.service;


import com.inventory_ms.inventory_ms.dto.InventoryDto;
import com.inventory_ms.inventory_ms.entity.InventoryEntity;
import com.inventory_ms.inventory_ms.repository.InventoryRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;

    public void createInventory(InventoryDto inventoryDto){
        InventoryEntity inventory = modelMapper.map(inventoryDto, InventoryEntity.class);
        inventoryRepository.findBySkuCode(inventory.getSkuCode()).ifPresent(inv -> {throw new EntityExistsException("inventory" + inv.getSkuCode() + "exist");});

        inventoryRepository.save(inventory);
        log.info("Product created success");
    }

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

}
