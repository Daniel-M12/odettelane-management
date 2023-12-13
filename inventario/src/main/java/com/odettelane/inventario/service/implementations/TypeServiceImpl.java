package com.odettelane.inventario.service.implementations;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.TypeDto;
import com.odettelane.inventario.persistence.entity.Type;
import com.odettelane.inventario.persistence.mapper.TypeMapper;
import com.odettelane.inventario.repository.TypeRepository;
import com.odettelane.inventario.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository repository;
    private final TypeMapper mapper;

    @Autowired
    public TypeServiceImpl(TypeRepository repository, TypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TypeDto> getAll() {
        List<Type> types = repository.findAll();
        return mapper.typeToDtos(types);
    }

    @Override
    public TypeDto read(Integer typeId) throws IdNotProvidedException, ItemNotFoundException {
        if (typeId == null) throw new IdNotProvidedException("Cannot read without providing an id");

        return mapper.typeToDto(findById(typeId));
    }

    @Override
    public Type create(TypeDto typeDto) throws AttributeNotProvidedException {
        if (typeDto.getType() == null) throw new AttributeNotProvidedException("type");

        return repository.save(mapper.dtoToType(typeDto));
    }

    @Override
    public TypeDto update(TypeDto typeDto, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, NotNegativeAttributeException, ItemNotFoundException {
        if (id == null) throw new IdNotProvidedException("Cannot update without providing an id");
        if (id < 0 ) throw new NotNegativeAttributeException("Id");
        if (typeDto.getType() == null) throw new AttributeNotProvidedException("type");

        findById(id); //Used to know if the type exists
        typeDto.setId(id);

        return mapper.typeToDto(repository.save(mapper.dtoToType(typeDto)));
    }

    @Override
    public String delete(Integer typeId) throws IdNotProvidedException, ItemNotFoundException {
        if (typeId == null) throw new IdNotProvidedException("Cannot delete without providing an id");

        repository.delete(findById(typeId));

        return repository.findById(typeId).isEmpty()? "Type removed successfully": "Type could not be removed";
    }

    private Type findById(Integer id) throws ItemNotFoundException {
        Optional<Type> optionalType = repository.findById(id);
        return optionalType.orElseThrow(() -> new ItemNotFoundException("Type"));
    }
}
