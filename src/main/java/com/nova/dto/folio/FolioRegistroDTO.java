package com.nova.dto.folio;

import com.nova.dto.AreaDto;
import com.nova.dto.EstadoReporteDto;
import com.nova.dto.UnidadDto;
import lombok.Value;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.nova.model.Folio}
 */
@Value
public class FolioRegistroDTO implements Serializable {
    Integer id;
    UnidadDto unidad;
    FolioDto.ReporteDto1 reporte;
    EstadoReporteDto estado;
    String folio;
    LocalDateTime fecha;
    String nota;
    String agente;

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