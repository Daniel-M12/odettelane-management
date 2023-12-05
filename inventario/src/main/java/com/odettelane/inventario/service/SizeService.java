package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.model.dto.SizeDto;
import com.odettelane.inventario.persistence.entity.Size;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SizeService {
    List<SizeDto> getAll();
    Size create(SizeDto sizeDto);
    SizeDto read(Integer sizeId) throws IdNotProvidedException;
    SizeDto update(SizeDto garment, Integer id) throws IdNotProvidedException;
    String delete(Integer sizeId) throws IdNotProvidedException;
}
