package com.nova.toolkit;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class FiltroFolio {
    private LocalDateTime fecha;
    private Integer estado, area, filas, pagina, unidad;
}
