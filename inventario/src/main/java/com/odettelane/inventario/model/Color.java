package com.odettelane.inventario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "color", schema = "inventario")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"co_id_color\"")
    private Integer id;
    @Column(name = "\"no_color_primario\"")
    private String primaryColor;
    @Column(name = "\"no_color_secundario\"")
    private String secondaryColor;
    @Column(name = "\"tx_distribucion\"")
    private String distribution;
}
