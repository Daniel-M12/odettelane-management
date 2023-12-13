package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.TypeDto;
import com.odettelane.inventario.persistence.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    List<TypeDto> getAll();
    TypeDto read(Integer typeId) throws IdNotProvidedException, ItemNotFoundException;
    Type create(TypeDto typeDto) throws AttributeNotProvidedException;
    TypeDto update(TypeDto size, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, NotNegativeAttributeException, ItemNotFoundException;
    String delete(Integer typeId) throws IdNotProvidedException, ItemNotFoundException;
}
