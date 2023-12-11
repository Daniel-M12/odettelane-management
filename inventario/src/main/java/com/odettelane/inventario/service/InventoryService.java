package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.InventoryDto;
import com.odettelane.inventario.model.request.InventoryRequest;
import com.odettelane.inventario.model.request.PageRequestOL;
import com.odettelane.inventario.persistence.entity.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<InventoryDto> getAll(PageRequestOL pageRequestOL) throws AttributeNotProvidedException, NotNegativeAttributeException;
    InventoryDto read(Integer inventoryId) throws IdNotProvidedException, ItemNotFoundException;
    Inventory create(InventoryRequest inventoryDto) throws AttributeNotProvidedException, IdNotProvidedException, NotNegativeAttributeException, ItemNotFoundException;
    InventoryDto update(Integer quantity, Integer id) throws IdNotProvidedException, ItemNotFoundException, AttributeNotProvidedException, NotNegativeAttributeException;
    String delete(Integer inventoryId) throws IdNotProvidedException, ItemNotFoundException;
}
