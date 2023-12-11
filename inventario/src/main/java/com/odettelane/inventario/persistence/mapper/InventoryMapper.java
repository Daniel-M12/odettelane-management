package com.odettelane.inventario.persistence.mapper;

import com.odettelane.inventario.model.dto.InventoryDto;
import com.odettelane.inventario.persistence.entity.Inventory;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GarmentMapper.class})
public interface InventoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "garment", target = "garment")
    })
    InventoryDto inventoryToDto(Inventory inventory);
    List<InventoryDto> inventoriesToDtos(List<Inventory> inventories);

    @InheritInverseConfiguration
    @Mapping(target = "garment", ignore = true)
    Inventory dtoToInventory(InventoryDto inventoryDto);
    List<Inventory> dtosToInventories(List<InventoryDto> inventoryDtos);
}
