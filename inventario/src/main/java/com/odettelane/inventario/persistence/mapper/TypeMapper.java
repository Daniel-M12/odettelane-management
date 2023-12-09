package com.odettelane.inventario.persistence.mapper;

import com.odettelane.inventario.model.dto.TypeDto;
import com.odettelane.inventario.persistence.entity.Type;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    TypeDto typeToDto(Type type);
    List<TypeDto> typeToDtos(List<Type> types);

    Type dtoToType(TypeDto typeDto);
    List<Type> dtoToTypes(List<TypeDto> typeDtos);
}
