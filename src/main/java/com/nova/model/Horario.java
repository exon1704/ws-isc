package com.nova.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operatividad")
    private Operatividad operatividad;

    @Column(name = "id_unidad")
    private Integer idUnidad;

    @Column(name = "apertura")
    private LocalTime apertura;

    @Column(name = "cierre")
    private LocalTime cierre;

}