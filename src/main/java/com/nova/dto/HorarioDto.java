package com.nova.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link com.nova.model.Horario}
 */
@Value
public class HorarioDto implements Serializable {
    Integer id;
    OperatividadDto operatividad;
    LocalTime apertura;
    LocalTime cierre;
}