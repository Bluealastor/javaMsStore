package com.inventory_ms.inventory_ms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {

    private Long id;
    private String skuCode;
    private Integer quantity;

}
