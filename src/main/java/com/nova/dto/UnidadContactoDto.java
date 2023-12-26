package com.nova.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.nova.model.UnidadContacto}
 */
@Value
public class UnidadContactoDto implements Serializable {
    Integer id;
    String telefono;
    String direccion;
}