package com.odettelane.inventario.service.implementations;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.request.PageRequestOL;
import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.model.dto.GarmentDto;
import com.odettelane.inventario.persistence.mapper.GarmentMapper;
import com.odettelane.inventario.repository.GarmentRepository;
import com.odettelane.inventario.service.GarmentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarmentServiceImpl implements GarmentService {
    private final GarmentRepository repository;
    private final GarmentMapper mapper;

    @Autowired
    public GarmentServiceImpl(GarmentRepository repository, GarmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<GarmentDto> getAll(PageRequestOL pageRequestOL) throws AttributeNotProvidedException, NotNegativeAttributeException {
        if (pageRequestOL.getPageNumber() == null || pageRequestOL.getPageSize() == null){
            throw new AttributeNotProvidedException("page request");
        }
        if (pageRequestOL.getPageNumber() < 0 || pageRequestOL.getPageSize() < 0){
            throw new NotNegativeAttributeException("Page request");
        }

        List<Garment> garments = repository.findAll(org.springframework.data.domain.PageRequest.of(pageRequestOL.getPageNumber(),
                pageRequestOL.getPageSize(),
                Sort.by("garment")))
                .toList();
        //List<Garment> garments = repository.findAll();
        return mapper.toGarmentDtos(garments);
    }

    @Override
    public GarmentDto read(Integer garmentId) throws IdNotProvidedException, ItemNotFoundException {
        if (garmentId == null) throw new IdNotProvidedException("Cannot read without providing an id");
        return mapper.garmentToDto(findById(garmentId));
    }

    @Override
    public Garment getGarment(Integer garmentId) throws IdNotProvidedException, ItemNotFoundException {
        if (garmentId == null) throw new IdNotProvidedException("Cannot read without providing an id");
        return findById(garmentId);
    }

    @Override
    public Garment create(@NotNull Garment garment) throws AttributeNotProvidedException, NotNegativeAttributeException {
        if (garment.getSizeId() == null) throw new AttributeNotProvidedException("size");
        if (garment.getColorId() == null) throw new AttributeNotProvidedException("color");
        if (garment.getFabricId() == null) throw new AttributeNotProvidedException("fabric");
        if (garment.getCategoryId() == null) throw new AttributeNotProvidedException("category");
        if (garment.getTypeId() == null) garment.setTypeId(1);

        if (garment.getSizeId() < 0 ||
            garment.getColorId() < 0 ||
            garment.getFabricId() < 0 ||
            garment.getCategoryId() < 0 ||
            garment.getTypeId() < 0){
            throw new NotNegativeAttributeException();
        }

        return repository.save(garment);
    }

    @Override
    public Garment update(@NotNull Garment garment, Integer id) throws IdNotProvidedException, NotNegativeAttributeException, ItemNotFoundException {
        if (id == null) throw new IdNotProvidedException("Cannot update without providing an id");

        /*if (garment.getSizeId() < 0 ||
                garment.getColorId() < 0 ||
                garment.getFabricId() < 0 ||
                garment.getCategoryId() < 0 ||
                garment.getTypeId() < 0){
            throw new NotNegativeAttributeException();
        }*/

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
    public String delete(Integer garmentId) throws IdNotProvidedException, ItemNotFoundException {
        if (garmentId == null) throw new IdNotProvidedException("Cannot delete without providing an id");

        repository.delete(findById(garmentId));

        return repository.findById(garmentId).isEmpty()? "Garment removed successfully": "Garment could not be removed";

    }

    private Garment findById(Integer id) throws ItemNotFoundException {
        Optional<Garment> optionalGarment = repository.findById(id);
        return optionalGarment.orElseThrow(() -> new ItemNotFoundException("Garment"));
    }
}
