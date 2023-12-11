package com.odettelane.inventario.service;

import com.odettelane.inventario.exceptions.AttributeNotProvidedException;
import com.odettelane.inventario.exceptions.IdNotProvidedException;
import com.odettelane.inventario.exceptions.ItemNotFoundException;
import com.odettelane.inventario.exceptions.NotNegativeAttributeException;
import com.odettelane.inventario.model.request.PageRequestOL;
import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.model.dto.GarmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GarmentService {
    List<GarmentDto> getAll(PageRequestOL pageRequestOL) throws NotNegativeAttributeException, AttributeNotProvidedException;
    GarmentDto read(Integer garmentId) throws IdNotProvidedException, ItemNotFoundException;
    Garment getGarment(Integer garmentId) throws IdNotProvidedException, ItemNotFoundException;
    Garment create(Garment garment) throws AttributeNotProvidedException, NotNegativeAttributeException;
    Garment update(Garment garment, Integer id) throws IdNotProvidedException, ItemNotFoundException, NotNegativeAttributeException;
    String delete(Integer garmentId) throws IdNotProvidedException, ItemNotFoundException;
}
