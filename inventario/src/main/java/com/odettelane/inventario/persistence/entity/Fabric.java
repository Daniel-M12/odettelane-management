package com.odettelane.inventario.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "fabric", cascade = CascadeType.ALL)
    private List<Garment> garments;
}
