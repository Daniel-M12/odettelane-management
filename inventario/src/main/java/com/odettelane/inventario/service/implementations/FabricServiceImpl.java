package com.odettelane.inventario.service.implementations;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.dto.FabricDto;
import com.odettelane.inventario.persistence.entity.Fabric;
import com.odettelane.inventario.persistence.mapper.FabricMapper;
import com.odettelane.inventario.repository.FabricRepository;
import com.odettelane.inventario.service.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricServiceImpl implements FabricService {
    private final FabricRepository repository;
    private final FabricMapper mapper;

    @Autowired
    public FabricServiceImpl(FabricRepository repository, FabricMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<FabricDto> getAll() {
        List<Fabric> fabrics = repository.findAll();
        return mapper.fabricToDtos(fabrics);
    }

    @Override
    public FabricDto read(Integer fabricId) throws IdNotProvidedException, ItemNotFoundException {
        if (fabricId == null) throw new IdNotProvidedException("Cannot read without providing an id");

        return mapper.fabricToDto(findById(fabricId));
    }

    @Override
    public Fabric create(FabricDto fabricDto) throws AttributeNotProvidedException {
        if (fabricDto.getFabric() == null) throw new AttributeNotProvidedException("fabric");

        return repository.save(mapper.dtoToFabric(fabricDto));
    }

    @Override
    public FabricDto update(FabricDto fabricDto, Integer id) throws IdNotProvidedException, AttributeNotProvidedException, NotNegativeAttributeException, ItemNotFoundException {
        if (id == null) throw new IdNotProvidedException("Cannot update without providing an id");
        if (id < 0 ) throw new NotNegativeAttributeException("Id");
        if (fabricDto.getFabric() == null) throw new AttributeNotProvidedException("fabric");

        findById(id); //Used to know if the fabric exists
        fabricDto.setId(id);

        return mapper.fabricToDto((repository.save(mapper.dtoToFabric(fabricDto))));
    }

    @Override
    public String delete(Integer fabricId) throws IdNotProvidedException, ItemNotFoundException {
        if (fabricId == null) throw new IdNotProvidedException("Cannot delete without providing an id");

        repository.delete(findById(fabricId));

        return repository.findById(fabricId).isEmpty()? "Fabric removed successfully": "Fabric could not be removed";
    }

    private Fabric findById(Integer id) throws ItemNotFoundException {
        Optional<Fabric> optionalFabric = repository.findById(id);
        return optionalFabric.orElseThrow(() -> new ItemNotFoundException("Fabric"));
    }
}
