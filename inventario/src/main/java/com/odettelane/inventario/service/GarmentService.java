package com.odettelane.inventario.service;

import com.odettelane.inventario.model.request.GarmentPageRequest;
import com.odettelane.inventario.persistence.entity.Garment;
import com.odettelane.inventario.model.dto.GarmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GarmentService {
    List<GarmentDto> getAll(GarmentPageRequest pageRequest);
    public Garment create(Garment garment);
    public GarmentDto read(Integer garmentId);
    public Garment update(Garment garment, Integer id);
    public String delete(Integer garmentId);
}
