package com.odettelane.inventario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
