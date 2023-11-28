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
@Table(name = "inventario", schema = "inventario")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"co_id_inventario\"")
    private Integer id;
    @Column(name = "\"nu_cantidad\"")
    private Integer quantity;
    @Column(name = "\"prenda_co_id_prenda\"")
    private Integer garmentId;
}
