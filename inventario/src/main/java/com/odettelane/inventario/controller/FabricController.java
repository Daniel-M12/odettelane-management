package com.odettelane.inventario.controller;

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
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{fabricId}")
    public ResponseEntity<?> getFabric(@PathVariable Integer fabricId){
        try {
            return new ResponseEntity<>(fabricService.read(fabricId),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FabricDto fabricDto) {
        if (fabricDto != null) {
            try {
                Fabric newFabric = fabricService.create(fabricDto);

                return new ResponseEntity<>(newFabric, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
