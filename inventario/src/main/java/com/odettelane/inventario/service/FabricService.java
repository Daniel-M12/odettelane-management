package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.FabricDto;
import com.odettelane.inventario.persistence.entity.Fabric;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FabricService {
    List<FabricDto> getAll();
    FabricDto read(Integer fabricId) throws IdNotProvidedException, ItemNotFoundException;
    Fabric create(FabricDto fabricDto) throws AttributeNotProvidedException;
    FabricDto update(FabricDto fabricDto, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, NotNegativeAttributeException, ItemNotFoundException;
    String delete(Integer fabricId) throws IdNotProvidedException, ItemNotFoundException;
}
