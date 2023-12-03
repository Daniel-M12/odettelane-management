package com.odettelane.inventario.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
    private List<Garment> garments;
}
