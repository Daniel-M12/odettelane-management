package com.odettelane.inventario.controller;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.TypeDto;
import com.odettelane.inventario.persistence.entity.Type;
import com.odettelane.inventario.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/types")
public class TypeController {
    private final TypeService typeService;
    
    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(typeService.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{typeId}")
    public ResponseEntity<?> getType(@PathVariable Integer typeId){
        try {
            return new ResponseEntity<>(typeService.read(typeId),HttpStatus.OK);
        } catch (IdNotProvidedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TypeDto typeDto){
        try {
            Type newType = typeService.create(typeDto);
            return new ResponseEntity<>(newType, HttpStatus.OK);
        } catch (AttributeNotProvidedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{typeId}")
    public ResponseEntity<?> update(@RequestBody TypeDto typeDto, @PathVariable Integer typeId){
        try {
            TypeDto updatedType = typeService.update(typeDto, typeId);
            return new ResponseEntity<>(updatedType, HttpStatus.OK);
        } catch (IdNotProvidedException | AttributeNotProvidedException | NotNegativeAttributeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{typeId}")
    public ResponseEntity<?> delete(@PathVariable Integer typeId){
        try {
            return new ResponseEntity<>(typeService.delete(typeId), HttpStatus.OK);
        } catch (IdNotProvidedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
