package com.odettelane.inventario.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GarmentDto {
    private Integer id;
    private String garment;
    private String size;
    private String color;
    private String fabric;
    private String category;
    private String type;
}
