package com.nova.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.nova.model.Operatividad}
 */
@Value
public class OperatividadDto implements Serializable {
    Integer id;
    String nombre;
}