package com.odettelane.inventario.controller;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.FabricDto;
import com.odettelane.inventario.persistence.entity.Fabric;
import com.odettelane.inventario.service.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabrics")
public class FabricController {
    private final FabricService fabricService;

    @Autowired
    public FabricController(FabricService fabricService) {
        this.fabricService = fabricService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(fabricService.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{fabricId}")
    public ResponseEntity<?> getFabric(@PathVariable Integer fabricId){
        try {
            return new ResponseEntity<>(fabricService.read(fabricId),HttpStatus.OK);
        } catch (IdNotProvidedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FabricDto fabricDto) {
        try {
            Fabric newFabric = fabricService.create(fabricDto);
            return new ResponseEntity<>(newFabric, HttpStatus.OK);
        } catch (AttributeNotProvidedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{fabricId}")
    public ResponseEntity<?> update(@RequestBody FabricDto fabricDto, @PathVariable Integer fabricId){
        try {
            FabricDto updatedFabric = fabricService.update(fabricDto, fabricId);
            return new ResponseEntity<>(updatedFabric, HttpStatus.OK);
        } catch (IdNotProvidedException | AttributeNotProvidedException | NotNegativeAttributeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{fabricId}")
    public ResponseEntity<?> delete(@PathVariable Integer fabricId){
        try {
            return new ResponseEntity<>(fabricService.delete(fabricId), HttpStatus.OK);
        } catch (IdNotProvidedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
