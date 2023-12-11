package com.odettelane.inventario.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "no_prenda")
    private String garment;

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

    @ManyToOne
    @JoinColumn(name = "\"talla_co_id_talla\"", insertable = false, updatable = false)
    @JsonIgnore
    private Size size;
    @ManyToOne
    @JoinColumn(name = "\"color_co_id_color\"", insertable = false, updatable = false)
    @JsonIgnore
    private Color color;
    @ManyToOne
    @JoinColumn(name = "\"tela_co_id_tela\"", insertable = false, updatable = false)
    @JsonIgnore
    private Fabric fabric;
    @ManyToOne
    @JoinColumn(name = "\"categoria_co_id_categoria\"", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;
    @ManyToOne
    @JoinColumn(name = "\"tipo_co_id_tipo\"", insertable = false, updatable = false)
    @JsonIgnore
    private Type type;

    @OneToOne(mappedBy = "garment")
    //@JsonIgnore
    private Inventory inventory;
}
