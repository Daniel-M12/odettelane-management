package com.odettelane.inventario.service;

import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.model.dto.GarmentDto;
import com.odettelane.inventario.persistence.mapper.GarmentMapper;
import com.odettelane.inventario.repository.GarmentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public GarmentDto read(Integer garmentId) {
        Optional<Garment> optionalGarment = repository.findById(garmentId);
        Garment garment = optionalGarment.orElseThrow(() -> new RuntimeException("Garment not found with that id"));

        GarmentDto garmentDto = mapper.garmentToDto(garment);

        return garmentDto;
    }

    @Override
    public Garment update(Garment garment) {
        return null;
    }

    @Override
    public boolean delete(Integer garmentId) {
        return false;
    }
}
