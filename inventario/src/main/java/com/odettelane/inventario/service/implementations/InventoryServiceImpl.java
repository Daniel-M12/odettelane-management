package com.odettelane.inventario.service.implementations;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.InventoryDto;
import com.odettelane.inventario.model.request.InventoryRequest;
import com.odettelane.inventario.model.request.PageRequestOL;
import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.persistence.entity.Inventory;
import com.odettelane.inventario.persistence.mapper.InventoryMapper;
import com.odettelane.inventario.repository.InventoryRepository;
import com.odettelane.inventario.service.GarmentService;
import com.odettelane.inventario.service.InventoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper mapper;
    private final GarmentService garmentService;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository, InventoryMapper mapper, GarmentService garmentService) {
        this.inventoryRepository = inventoryRepository;
        this.mapper = mapper;
        this.garmentService = garmentService;
    }

    @Override
    public List<InventoryDto> getAll(@NotNull PageRequestOL pageRequestOL) throws NotNegativeAttributeException, AttributeNotProvidedException {
        if (pageRequestOL.getPageNumber() == null || pageRequestOL.getPageSize() == null){
            throw new AttributeNotProvidedException("page request");
        }
        if (pageRequestOL.getPageNumber() < 0 || pageRequestOL.getPageSize() < 0){
            throw new NotNegativeAttributeException("Page request");
        }

        List<Inventory> inventoryList = inventoryRepository.findAll(
                PageRequest.of(pageRequestOL.getPageNumber(),
                        pageRequestOL.getPageSize()))
                .toList();
        return mapper.inventoriesToDtos(inventoryList);
    }

    @Override
    public InventoryDto read(Integer inventoryId) throws IdNotProvidedException, ItemNotFoundException {
        if (inventoryId == null) throw new IdNotProvidedException("Cannot read without providing an id.");
        return mapper.inventoryToDto(findById(inventoryId));
    }

    @Override
    public Inventory create(@NotNull InventoryRequest inventoryRequest) throws AttributeNotProvidedException, IdNotProvidedException, NotNegativeAttributeException, ItemNotFoundException {
        if (inventoryRequest.getGarmentId() == null) throw new AttributeNotProvidedException("garment id");
        if (inventoryRequest.getQuantity() == null) throw new AttributeNotProvidedException("quantity");
        if (inventoryRequest.getQuantity() < 0) throw new NotNegativeAttributeException("Quantity");

        Garment selectedGarment = garmentService.getGarment(inventoryRequest.getGarmentId());

        Inventory inventory = new Inventory();
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setGarment(selectedGarment);

        return inventoryRepository.save(inventory);
    }

    @Override
    public InventoryDto update(@NotNull Integer quantity, Integer inventoryItemId) throws IdNotProvidedException, ItemNotFoundException, AttributeNotProvidedException, NotNegativeAttributeException {
        if (inventoryItemId == null) throw new IdNotProvidedException("Cannot update without providing an id.");
        if (quantity < 0) throw new NotNegativeAttributeException("Quantity");

        Inventory oldInventoryItem = findById(inventoryItemId);

        oldInventoryItem.setQuantity(quantity);

        return mapper.inventoryToDto(inventoryRepository.save(oldInventoryItem));
    }

    @Override
    public String delete(Integer inventoryId) throws IdNotProvidedException, ItemNotFoundException {
        if (inventoryId == null) throw new IdNotProvidedException("Cannot delete without providing an id");

        if (inventoryRepository.existsById(inventoryId)) {
            inventoryRepository.deleteById(inventoryId);
            return inventoryRepository.existsById(inventoryId)? "Inventory item could not be removed": "Inventory item removed successfully";
        } else {
            throw new ItemNotFoundException("Inventory item");
        }
    }

    private Inventory findById(Integer id) throws ItemNotFoundException {
        Optional<Inventory> optionalInventoryItem = inventoryRepository.findById(id);
        return optionalInventoryItem.orElseThrow(() -> new ItemNotFoundException("Inventory item"));
    }
}
