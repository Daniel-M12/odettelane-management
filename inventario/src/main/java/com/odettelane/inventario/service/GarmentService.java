package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.model.request.GarmentPageRequest;
import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.model.dto.GarmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GarmentService {
    List<GarmentDto> getAll(GarmentPageRequest pageRequest);
    Garment create(Garment garment) throws AttributeNotProvidedException;
    GarmentDto read(Integer garmentId) throws IdNotProvidedException;
    Garment update(Garment garment, Integer id) throws IdNotProvidedException;
    String delete(Integer garmentId) throws IdNotProvidedException;
}
