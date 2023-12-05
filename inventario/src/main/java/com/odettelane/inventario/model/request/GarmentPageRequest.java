package com.odettelane.inventario.model.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Getter
@Setter
public class GarmentPageRequest {
    private Integer pageNumber;
    private Integer pageSize;
}
