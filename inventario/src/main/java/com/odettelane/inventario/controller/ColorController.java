package com.odettelane.inventario.controller;

import com.odettelane.inventario.model.dto.ColorDto;
import com.odettelane.inventario.persistence.entity.Color;
import com.odettelane.inventario.service.ColorSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colors")
public class ColorController {
    private final ColorSerivice colorSerivice;

    @Autowired
    public ColorController(ColorSerivice colorSerivice) {
        this.colorSerivice = colorSerivice;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(colorSerivice.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{colorId}")
    public ResponseEntity<?> getGarment(@PathVariable Integer colorId){
        try {
            return new ResponseEntity<>(colorSerivice.read(colorId),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ColorDto colorDto){
        if (colorDto != null){
            try {
                Color newColor = colorSerivice.create(colorDto);

                return new ResponseEntity<>(newColor, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{colorId}")
    public ResponseEntity<?> update(@RequestBody ColorDto colorDto, @PathVariable Integer colorId){
        try {
            ColorDto updatedColor = colorSerivice.update(colorDto, colorId);

            return new ResponseEntity<>(updatedColor, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{colorId}")
    public ResponseEntity<?> delete(@PathVariable Integer colorId){
        try {
            return new ResponseEntity<>(colorSerivice.delete(colorId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
