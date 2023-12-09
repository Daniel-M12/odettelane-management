package com.odettelane.inventario.service.implementations;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.model.dto.CategoryDto;
import com.odettelane.inventario.persistence.entity.Category;
import com.odettelane.inventario.persistence.mapper.CategoryMapper;
import com.odettelane.inventario.repository.CategoryRepository;
import com.odettelane.inventario.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = repository.findAll();
        return mapper.categoryToDtos(categories);
    }

    @Override
    public Category create(CategoryDto categoryDto) throws AttributeNotProvidedException {
        if (categoryDto.getCategory() == null) throw new AttributeNotProvidedException("category");

        return repository.save(mapper.dtoToCategory(categoryDto));
    }

    @Override
    public CategoryDto read(Integer categoryId) throws IdNotProvidedException {
        if (categoryId == null) throw new IdNotProvidedException("Cannot read without providing an id");

        return mapper.categoryToDto(findById(categoryId));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Integer id) throws IdNotProvidedException, AttributeNotProvidedException {
        if (id == null) throw new IdNotProvidedException("Cannot update without providing an id");
        if (categoryDto.getCategory() == null) throw new AttributeNotProvidedException("category");

        return mapper.categoryToDto(repository.save(mapper.dtoToCategory(categoryDto)));
    }

    @Override
    public String delete(Integer categoryId) throws IdNotProvidedException {
        if (categoryId == null) throw new IdNotProvidedException("Cannot delete without providing an id");

        repository.delete(findById(categoryId));

        return repository.findById(categoryId).isEmpty()? "Category removed successfully": "Category could not be removed";
    }

    private Category findById(Integer id){
        Optional<Category> optionalCategory = repository.findById(id);
        return optionalCategory.orElseThrow(() -> new RuntimeException("Category not found with that id"));
    }
}
