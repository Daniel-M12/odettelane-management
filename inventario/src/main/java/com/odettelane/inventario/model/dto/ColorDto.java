package com.odettelane.inventario.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColorDto {
    private Integer id;
    private String primaryColor;
    private String secondaryColor;
    private String distribution;
}
