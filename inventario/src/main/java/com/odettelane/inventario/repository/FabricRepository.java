package com.odettelane.inventario.repository;

import com.odettelane.inventario.persistence.entity.Fabric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricRepository extends JpaRepository<Fabric, Integer> {
}
