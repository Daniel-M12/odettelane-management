package com.odettelane.inventario.model.request;

import com.odettelane.inventario.model.dto.GarmentDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequest {
    private Integer garmentId;
    private Integer quantity;
}
