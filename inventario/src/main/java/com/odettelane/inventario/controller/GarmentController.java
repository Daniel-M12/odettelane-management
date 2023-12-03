package com.odettelane.inventario.controller;

import com.odettelane.inventario.model.dto.GarmentDto;
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

    @GetMapping("/{garmentId}")
    public ResponseEntity<?> getGarment(@PathVariable Integer garmentId){
        try {
            return new ResponseEntity<>(garmentService.read(garmentId),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Garment garment){
        if (garment != null){
            try {
                Garment newGarment = garmentService.create(garment);

                return new ResponseEntity<>(newGarment, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
