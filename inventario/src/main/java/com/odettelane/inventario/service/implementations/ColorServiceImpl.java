package com.odettelane.inventario.service.implementations;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.ColorDto;
import com.odettelane.inventario.persistence.entity.Color;
import com.odettelane.inventario.persistence.mapper.ColorMapper;
import com.odettelane.inventario.repository.ColorRepository;
import com.odettelane.inventario.service.ColorSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorSerivice {
    private final ColorRepository repository;
    private final ColorMapper mapper;

    @Autowired
    public ColorServiceImpl(ColorRepository repository, ColorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ColorDto> getAll() {
        List<Color> colors = repository.findAll();
        return mapper.toColorDtos(colors);
    }

    @Override
    public ColorDto read(Integer colorId) throws IdNotProvidedException, ItemNotFoundException {
        if (colorId == null) throw new IdNotProvidedException("Cannot read without providing an id");

        return mapper.colorToDto(findById(colorId));
    }

    @Override
    public Color create(ColorDto colorDto) throws AttributeNotProvidedException {
        if (colorDto.getPrimaryColor() == null) throw new AttributeNotProvidedException("primary color");

        return repository.save(mapper.dtoToColor(colorDto));
    }

    @Override
    public ColorDto update(ColorDto colorDto, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, NotNegativeAttributeException, ItemNotFoundException {
        if (id == null) throw new IdNotProvidedException("Cannot update without providing an id");
        if (id < 0 ) throw new NotNegativeAttributeException("Id");
        if (colorDto.getPrimaryColor() == null &&
        colorDto.getSecondaryColor() == null &&
        colorDto.getDistribution() == null) {
            throw new AttributeNotProvidedException();
        }

        Color oldColor = findById(id);
        if (colorDto.getPrimaryColor() == null) {
            colorDto.setPrimaryColor(oldColor.getPrimaryColor());
        }
        if (colorDto.getSecondaryColor() == null && oldColor.getSecondaryColor() != null) {
            colorDto.setSecondaryColor(oldColor.getSecondaryColor());
        }
        if (colorDto.getDistribution() == null && oldColor.getDistribution() != null) {
            colorDto.setDistribution(oldColor.getDistribution());
        }

        colorDto.setId(id);

        return mapper.colorToDto(repository.save(mapper.dtoToColor(colorDto)));
    }

    @Override
    public String delete(Integer colorId) throws IdNotProvidedException, ItemNotFoundException {
        if (colorId == null) throw new IdNotProvidedException("Cannot delete without providing an id");

        repository.delete(findById(colorId));

        return repository.findById(colorId).isEmpty()? "Color removed successfully": "Color could not be removed";
    }

    private Color findById(Integer id) throws ItemNotFoundException {
        Optional<Color> optionalColor = repository.findById(id);
        return optionalColor.orElseThrow(() -> new ItemNotFoundException("Color"));
    }
}
