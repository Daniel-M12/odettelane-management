package com.odettelane.inventario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tela", schema = "inventario")
public class Fabric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"co_id_tela\"")
    private Integer id;
    @Column(name = "\"no_tela\"")
    private String fabric;
}
