package com.odettelane.inventario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "talla", schema = "inventario")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"co_id_talla\"")
    private Integer id;
    @Column(name = "\"no_talla\"")
    private String size;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    private List<Garment> garments;
}
