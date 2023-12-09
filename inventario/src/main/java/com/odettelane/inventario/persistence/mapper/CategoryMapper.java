package com.odettelane.inventario.persistence.mapper;

import com.odettelane.inventario.model.dto.CategoryDto;
import com.odettelane.inventario.model.dto.SizeDto;
import com.odettelane.inventario.persistence.entity.Category;
import com.odettelane.inventario.persistence.entity.Size;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto categoryToDto(Category category);
    List<CategoryDto> categoryToDtos(List<Category> categories);

    Category dtoToCategory(CategoryDto categoryDto);
    List<Category> dtoToCategories(List<CategoryDto> categoryDtos);
}
