package com.nova.projections;

import com.nova.model.Folio;

import java.time.LocalDateTime;

/**
 * Projection for {@link Folio}
 */
public interface FolioInfo {
    Integer getId();

    String getFolio();

    LocalDateTime getFecha();

    ReporteInfo getReporte();

    EstadoReporteInfo getEstado();

    UnidadInfo getUnidad();

    /**
     * Projection for {@link com.nova.model.Reporte}
     */
    interface ReporteInfo {
        Integer getId();

        String getNombre();

        AreaInfo getArea();

        /**
         * Projection for {@link com.nova.model.Area}
         */
        interface AreaInfo {
            Integer getId();

            String getNombre();
        }
    }

    /**
     * Projection for {@link com.nova.model.EstadoReporte}
     */
    interface EstadoReporteInfo {
        Integer getId();

        String getNombre();
    }
}