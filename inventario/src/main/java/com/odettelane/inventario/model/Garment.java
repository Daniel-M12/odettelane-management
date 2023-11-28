package com.odettelane.inventario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prenda", schema = "inventario")
public class Garment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"co_id_prenda\"")
    private Integer id;
    @Column(name = "\"talla_co_id_talla\"")
    private Integer sizeId;
    @Column(name = "\"color_co_id_color\"")
    private Integer colorId;
    @Column(name = "\"tela_co_id_tela\"")
    private Integer fabricId;
    @Column(name = "\"categoria_co_id_categoria\"")
    private Integer categoryId;
    @Column(name = "\"tipo_co_id_tipo\"")
    private Integer typeId;

}
