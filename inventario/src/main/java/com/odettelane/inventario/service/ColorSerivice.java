package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.ColorDto;
import com.odettelane.inventario.persistence.entity.Color;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColorSerivice {
    List<ColorDto> getAll();
    ColorDto read(Integer colorId) throws IdNotProvidedException, ItemNotFoundException;
    Color create(ColorDto colorDto) throws AttributeNotProvidedException;
    ColorDto update(ColorDto colorDto, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, NotNegativeAttributeException, ItemNotFoundException;
    String delete(Integer colorId) throws IdNotProvidedException, ItemNotFoundException;
}
