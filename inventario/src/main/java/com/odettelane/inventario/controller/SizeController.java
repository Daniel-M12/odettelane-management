package com.odettelane.inventario.controller;

import com.odettelane.inventario.model.dto.SizeDto;
import com.odettelane.inventario.persistence.entity.Size;
import com.odettelane.inventario.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sizes")
public class SizeController {
    private final SizeService sizeService;

    @Autowired
    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(sizeService.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{sizeId}")
    public ResponseEntity<?> getSize(@PathVariable Integer sizeId){
        try {
            return new ResponseEntity<>(sizeService.read(sizeId),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody SizeDto sizeDto){
        if (sizeDto != null){
            try {
                Size newSize = sizeService.create(sizeDto);

                return new ResponseEntity<>(newSize, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{sizeId}")
    public ResponseEntity<?> update(@RequestBody SizeDto sizeDto, @PathVariable Integer sizeId){
        try {
            SizeDto updatedSize = sizeService.update(sizeDto, sizeId);

            return new ResponseEntity<>(updatedSize, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{sizeId}")
    public ResponseEntity<?> delete(@PathVariable Integer sizeId){
        try {
            return new ResponseEntity<>(sizeService.delete(sizeId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
