package com.odettelane.inventario.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tipo", schema = "inventario")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"co_id_tipo\"")
    private Integer id;
    @Column(name = "\"no_tipo\"")
    private String type;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Garment> garments;
}
