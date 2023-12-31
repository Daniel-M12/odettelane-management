package com.odettelane.inventario.controller;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.request.PageRequestOL;
import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.service.GarmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garments")
public class GarmentController {
    private final GarmentService garmentService;

    @Autowired
    public GarmentController(GarmentService garmentService) {
        this.garmentService = garmentService;
    }

    @PostMapping
    public ResponseEntity<?> getAll(@RequestBody PageRequestOL pageRequestOL){
        try {
            return new ResponseEntity<>(garmentService.getAll(pageRequestOL), HttpStatus.OK);
        } catch (AttributeNotProvidedException | NotNegativeAttributeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{garmentId}")
    public ResponseEntity<?> getGarment(@PathVariable Integer garmentId){
        try {
            return new ResponseEntity<>(garmentService.read(garmentId),HttpStatus.OK);
        } catch (IdNotProvidedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Garment garment){
        try {
            Garment newGarment = garmentService.create(garment);
            return new ResponseEntity<>(newGarment, HttpStatus.OK);
        } catch (AttributeNotProvidedException | NotNegativeAttributeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{garmentId}")
    public ResponseEntity<?> update(@RequestBody Garment garment, @PathVariable Integer garmentId){
        try {
            Garment updatedGarment = garmentService.update(garment, garmentId);
            return new ResponseEntity<>(updatedGarment, HttpStatus.OK);
        } catch (IdNotProvidedException | NotNegativeAttributeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{garmentId}")
    public ResponseEntity<?> delete(@PathVariable Integer garmentId){
        try {
            return new ResponseEntity<>(garmentService.delete(garmentId), HttpStatus.OK);
        } catch (IdNotProvidedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
