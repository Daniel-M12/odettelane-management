package com.odettelane.inventario.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private Integer id;
    private Integer quantity;
    private GarmentDto garment;
}
