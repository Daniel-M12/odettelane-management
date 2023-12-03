package com.odettelane.inventario.model.response;

import com.odettelane.inventario.persistence.entity.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GarmentResponse {
    private Integer id;
    private Size size;
    private Color color;
    private Fabric fabric;
    private Category category;
    private Type type;
}
