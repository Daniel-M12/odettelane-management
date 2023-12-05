package com.odettelane.inventario.persistence.mapper;

import com.odettelane.inventario.model.dto.SizeDto;
import com.odettelane.inventario.persistence.entity.Size;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SizeMapper {

    SizeDto sizetoDto(Size size);
    List<SizeDto> sizeToDtos(List<Size> sizes);

    Size dtoToSize(SizeDto sizeDto);
    List<Size> dtoToSizes(List<SizeDto> sizeDtos);
}
