package com.odettelane.inventario.repository;

import com.odettelane.inventario.persistence.entity.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarmentRepository extends JpaRepository<Garment, Integer> {
    /*@Query(value = "SELECT p.no_prenda FROM prenda as p", nativeQuery = true)
    Optional<Garment> getGarmentBy(Integer garmentId);*/
}
