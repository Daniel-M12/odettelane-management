package com.odettelane.inventario.persistence.mapper;

import com.odettelane.inventario.model.dto.FabricDto;
import com.odettelane.inventario.persistence.entity.Fabric;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FabricMapper {
    FabricDto fabricToDto(Fabric fabric);
    List<FabricDto> fabricToDtos(List<Fabric> fabrics);

    Fabric dtoToFabric(FabricDto fabricDto);
    List<Fabric> dtoToFabrics(List<FabricDto> fabricDtos);
}
