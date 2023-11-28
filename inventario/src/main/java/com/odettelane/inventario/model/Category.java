package com.odettelane.inventario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria", schema = "inventario")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"co_id_categoria\"")
    private Integer id;
    @Column(name = "\"no_categoria\"")
    private String category;
}
