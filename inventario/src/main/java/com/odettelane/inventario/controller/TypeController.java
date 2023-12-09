package com.odettelane.inventario.controller;

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
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{typeId}")
    public ResponseEntity<?> getType(@PathVariable Integer typeId){
        try {
            return new ResponseEntity<>(typeService.read(typeId),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TypeDto typeDto){
        if (typeDto != null){
            try {
                Type newType = typeService.create(typeDto);

                return new ResponseEntity<>(newType, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{typeId}")
    public ResponseEntity<?> update(@RequestBody TypeDto typeDto, @PathVariable Integer typeId){
        try {
            TypeDto updatedType = typeService.update(typeDto, typeId);

            return new ResponseEntity<>(updatedType, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{typeId}")
    public ResponseEntity<?> delete(@PathVariable Integer typeId){
        try {
            return new ResponseEntity<>(typeService.delete(typeId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
