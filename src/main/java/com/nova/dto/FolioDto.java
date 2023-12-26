package com.nova.dto;

import com.nova.model.Folio;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Folio}
 */
@Value
public class FolioDto implements Serializable {
    Integer id;
    UnidadDto unidad;
    ReporteDto1 reporte;
    EstadoReporteDto estado;
    String folio;
    LocalDateTime fecha;

    /**
     * DTO for {@link com.nova.model.Reporte}
     */
    @Value
    public static class ReporteDto1 implements Serializable {
        Integer id;
        AreaDto area;
        String nombre;
    }
}