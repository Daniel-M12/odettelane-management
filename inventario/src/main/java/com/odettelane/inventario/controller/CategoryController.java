package com.odettelane.inventario.controller;

import com.odettelane.inventario.model.dto.CategoryDto;
import com.odettelane.inventario.persistence.entity.Category;
import com.odettelane.inventario.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable Integer categoryId){
        try {
            return new ResponseEntity<>(categoryService.read(categoryId),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto){
        if (categoryDto != null){
            try {
                Category newCategory = categoryService.create(categoryDto);

                return new ResponseEntity<>(newCategory, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<?> update(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        try {
            CategoryDto updatedCategory = categoryService.update(categoryDto, categoryId);

            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> delete(@PathVariable Integer categoryId){
        try {
            return new ResponseEntity<>(categoryService.delete(categoryId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
