package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.model.dto.TypeDto;
import com.odettelane.inventario.persistence.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    List<TypeDto> getAll();
    Type create(TypeDto typeDto) throws AttributeNotProvidedException;
    TypeDto read(Integer typeId) throws IdNotProvidedException;
    TypeDto update(TypeDto size, Integer id) throws IdNotProvidedException, AttributeNotProvidedException;
    String delete(Integer typeId) throws IdNotProvidedException;
}
