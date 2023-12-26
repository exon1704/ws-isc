package com.nova.projections;

import com.nova.model.Unidad;

/**
 * Projection for {@link Unidad}
 */
public interface UnidadInfo {
    Integer getId();

    String getClave();

    String getNombre();
}