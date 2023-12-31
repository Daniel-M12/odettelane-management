package com.odettelane.inventario.service.implementations;

import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.SizeDto;
import com.odettelane.inventario.persistence.entity.Size;
import com.odettelane.inventario.persistence.mapper.SizeMapper;
import com.odettelane.inventario.repository.SizeRepository;
import com.odettelane.inventario.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {
    private final SizeRepository repository;
    private final SizeMapper mapper;

    @Autowired
    public SizeServiceImpl(SizeRepository repository, SizeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<SizeDto> getAll() {
        List<Size> sizes = repository.findAll();
        return mapper.sizeToDtos(sizes);
    }

    @Override
    public SizeDto read(Integer sizeId) throws IdNotProvidedException, ItemNotFoundException {
        if (sizeId == null) throw new IdNotProvidedException("Cannot read without providing an id");

        return mapper.sizeToDto(findById(sizeId));
    }

    @Override
    public Size create(SizeDto sizeDto) throws AttributeNotProvidedException {
        if (sizeDto.getSize() == null) throw new AttributeNotProvidedException("size");

        return repository.save(mapper.dtoToSize(sizeDto));
    }

    @Override
    public SizeDto update(SizeDto sizeDto, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, NotNegativeAttributeException, ItemNotFoundException {
        if (id == null) throw new IdNotProvidedException("Cannot update without providing an id");
        if (id < 0 ) throw new NotNegativeAttributeException("Id");
        if (sizeDto.getSize() == null) throw new AttributeNotProvidedException("size");

        findById(id); //Used to know if the size exists
        sizeDto.setId(id);

        return mapper.sizeToDto(repository.save(mapper.dtoToSize(sizeDto)));
    }

    @Override
    public String delete(Integer sizeId) throws IdNotProvidedException, ItemNotFoundException {
        if (sizeId == null) throw new IdNotProvidedException("Cannot delete without providing an id");

        repository.delete(findById(sizeId));

        return repository.findById(sizeId).isEmpty()? "Size removed successfully": "Size could not be removed";
    }

    private Size findById(Integer id) throws ItemNotFoundException {
        Optional<Size> optionalSize = repository.findById(id);
        return optionalSize.orElseThrow(() -> new ItemNotFoundException("Size"));
    }
}
