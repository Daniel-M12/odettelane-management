package com.odettelane.inventario.service;

import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.model.dto.GarmentDto;
import org.springframework.stereotype.Service;

@Service
public interface GarmentService {
    public Garment create(Garment garment);
    public GarmentDto read(Integer garmentId);
    public Garment update(Garment garment);
    public boolean delete(Integer garmentId);
}
