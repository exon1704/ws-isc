package com.nova.service.unidad;

import com.nova.model.Horario;
import com.nova.model.UnidadContacto;
import com.nova.projections.UnidadInfo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UnidadService {
    List<UnidadInfo> obtenerTodoSimple();

    Optional<UnidadContacto> obtenerContacto(Integer id);

    Collection<Horario> obtenerHorarios(Integer idUnidad);
}