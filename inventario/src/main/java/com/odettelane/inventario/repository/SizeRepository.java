package com.odettelane.inventario.repository;

import com.odettelane.inventario.persistence.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
}
