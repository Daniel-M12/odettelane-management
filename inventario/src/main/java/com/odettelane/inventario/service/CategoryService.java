package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.CategoryDto;
import com.odettelane.inventario.persistence.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto read(Integer categoryId) throws IdNotProvidedException, ItemNotFoundException;
    Category create(CategoryDto categoryDto) throws AttributeNotProvidedException;
    CategoryDto update(CategoryDto category, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, ItemNotFoundException, NotNegativeAttributeException;
    String delete(Integer categoryId) throws IdNotProvidedException, ItemNotFoundException;
}
