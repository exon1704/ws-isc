package com.nova.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.nova.model.Unidad}
 */
@Value
public class UnidadDto implements Serializable {
    Integer id;
    String clave;
    String nombre;
}