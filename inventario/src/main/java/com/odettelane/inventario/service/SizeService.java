package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.SizeDto;
import com.odettelane.inventario.persistence.entity.Size;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SizeService {
    List<SizeDto> getAll();
    SizeDto read(Integer sizeId) throws IdNotProvidedException, ItemNotFoundException;
    Size create(SizeDto sizeDto) throws AttributeNotProvidedException;
    SizeDto update(SizeDto sizeDto, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, NotNegativeAttributeException, ItemNotFoundException;
    String delete(Integer sizeId) throws IdNotProvidedException, ItemNotFoundException;
}
