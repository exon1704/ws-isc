package com.nova.projections;

import java.time.LocalDateTime;

/**
 * Projection for {@link com.nova.model.Folio}
 */
public interface FolioDetalles extends FolioSimple {
    String getNota();
    String getAgente();
}