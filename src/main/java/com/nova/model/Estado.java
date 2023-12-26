package com.nova.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", nullable = false)
    private Integer id;

    @Column(name = "clave", nullable = false, length = 5)
    private String clave;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

}