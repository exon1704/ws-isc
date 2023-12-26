package com.nova.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Collection;

@Value
public class GeneralesDTO implements Serializable {
    UnidadContactoDto contacto;
    Collection<HorarioDto> horarios;
}
