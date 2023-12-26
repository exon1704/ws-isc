package com.nova.dto;

import lombok.Value;

import java.io.Serializable;

@Value
public class EstadoReporteDto implements Serializable {
    Integer id;
    String nombre;
}