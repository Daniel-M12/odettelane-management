package com.odettelane.inventario.persistence.mapper;

import com.odettelane.inventario.model.dto.GarmentDto;
import com.odettelane.inventario.persistence.entity.Garment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GarmentMapper {
    /*@Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "garment", target = "garment"),
            @Mapping(source = "size.size", target = "size"),
            @Mapping(source = "color.primaryColor", target = "color"),
            @Mapping(source = "fabric.fabric", target = "fabric"),
            @Mapping(source = "category.category", target = "category"),
            @Mapping(source = "type.type", target = "type")
    })*/
    public GarmentDto garmentToDto(Garment garment){
        GarmentDto garmentDto = GarmentDto.builder()
                .id(garment.getId())
                .garment(garment.getGarment())
                .size(garment.getSize().getSize())
                .fabric(garment.getFabric().getFabric())
                .category(garment.getCategory().getCategory())
                .type(garment.getType().getType())
                .build();

        if (garment.getColor().getSecondaryColor() == null){
            garmentDto.setColor(garment.getColor().getPrimaryColor());
        } else {
            String compositeColor;
            if (garment.getColor().getDistribution() != null){
                compositeColor = garment.getColor().getPrimaryColor()
                        + " - " + garment.getColor().getSecondaryColor()
                        + ": " + garment.getColor().getDistribution();
            } else {
                compositeColor = garment.getColor().getPrimaryColor()
                        + " - " + garment.getColor().getSecondaryColor();
            }
            garmentDto.setColor(compositeColor);
        }

        return garmentDto;
    }

    public abstract List<GarmentDto> garmentDtos(List<Garment> garments);
}
