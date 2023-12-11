package com.odettelane.inventario.controller;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.InventoryDto;
import com.odettelane.inventario.model.request.InventoryRequest;
import com.odettelane.inventario.model.request.PageRequestOL;
import com.odettelane.inventario.persistence.entity.Inventory;
import com.odettelane.inventario.service.InventoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventoryItems")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestBody PageRequestOL pageRequestOL){
        try {
            return new ResponseEntity<>(inventoryService.getAll(pageRequestOL), HttpStatus.OK);
        } catch (AttributeNotProvidedException | NotNegativeAttributeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<?> getInventoryItem(@PathVariable Integer inventoryId){
        try {
            return new ResponseEntity<>(inventoryService.read(inventoryId),HttpStatus.OK);
        } catch (IdNotProvidedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @NotNull InventoryRequest inventoryRequest){
        try {
            Inventory newInventoryItem = inventoryService.create(inventoryRequest);
            return new ResponseEntity<>(newInventoryItem, HttpStatus.OK);
        } catch (AttributeNotProvidedException | IdNotProvidedException | NotNegativeAttributeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{inventoryId}")
    public ResponseEntity<?> update(@RequestParam Integer quantity, @PathVariable Integer inventoryId){
        try {
            InventoryDto updatedInventoryItem = inventoryService.update(quantity, inventoryId);
            return new ResponseEntity<>(updatedInventoryItem, HttpStatus.OK);
        } catch (IdNotProvidedException | AttributeNotProvidedException | NotNegativeAttributeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{inventoryId}")
    public ResponseEntity<?> delete(@PathVariable Integer inventoryId){
        try {
            return new ResponseEntity<>(inventoryService.delete(inventoryId), HttpStatus.OK);
        } catch (IdNotProvidedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
