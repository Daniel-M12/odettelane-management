package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.model.request.GarmentPageRequest;
import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.model.dto.GarmentDto;
import com.odettelane.inventario.persistence.mapper.GarmentMapper;
import com.odettelane.inventario.repository.GarmentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarmentServiceImpl implements GarmentService{
    private final GarmentRepository repository;
    private final GarmentMapper mapper;

    @Autowired
    public GarmentServiceImpl(GarmentRepository repository, GarmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Garment create(@NotNull Garment garment) {
        if (garment.getSizeId() == null) throw new RuntimeException("You must provide a size"); //TODO: Personalizar excepciones
        if (garment.getColorId() == null) throw new RuntimeException("You must provide a color");
        if (garment.getFabricId() == null) throw new RuntimeException("You must provide a fabric");
        if (garment.getCategoryId() == null) throw new RuntimeException("You must provide a category");
        if (garment.getTypeId() == null) garment.setTypeId(1);

        return repository.save(garment);
    }

    @Override
    public List<GarmentDto> getAll(GarmentPageRequest pageRequest){
        List<Garment> garments = repository.findAll(PageRequest.of(pageRequest.getPageNumber(),
                pageRequest.getPageSize(),
                Sort.by("garment")))
                .toList();
        //List<Garment> garments = repository.findAll();
        return mapper.toGarmentDtos(garments);
    }

    @Override
    public GarmentDto read(Integer garmentId) throws IdNotProvidedException {
        if (garmentId == null) throw new IdNotProvidedException("Cannot read without providing an id");
        return mapper.garmentToDto(findById(garmentId));
    }

    @Override
    public Garment update(Garment garment, Integer id) throws IdNotProvidedException {
        if (id == null) throw new IdNotProvidedException("Cannot update without providing an id");

        Garment oldGarment = findById(id);

        garment.setId(id);
        if (garment.getGarment() == null) garment.setGarment(oldGarment.getGarment());
        if (garment.getSizeId() == null) garment.setSizeId(oldGarment.getSizeId());
        if (garment.getColorId() == null) garment.setColorId(oldGarment.getColorId());
        if (garment.getFabricId() == null) garment.setFabricId(oldGarment.getFabricId());
        if (garment.getCategoryId() == null) garment.setCategoryId(oldGarment.getCategoryId());
        if (garment.getTypeId() == null) garment.setTypeId(oldGarment.getTypeId());

        return repository.save(garment);
    }

    @Override
    public String delete(Integer garmentId) throws IdNotProvidedException {
        if (garmentId == null) throw new IdNotProvidedException("Cannot delete without providing an id");

        repository.delete(findById(garmentId));

        return repository.findById(garmentId).isEmpty()? "Garment removed successfully": "Garment could not be removed";

    }

    private Garment findById(Integer id){
        Optional<Garment> optionalGarment = repository.findById(id);
        return optionalGarment.orElseThrow(() -> new RuntimeException("Garment not found with that id"));
    }
}
