package com.nova.service.folio;

import com.nova.model.Folio;
import com.nova.projections.FolioDetalles;
import com.nova.projections.FolioSimple;
import com.nova.toolkit.FiltroFolio;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface FolioService {
    Optional<FolioSimple> obtenerPorFolio(String folio);
    Optional<FolioDetalles> obtenerDetalles(String folio);

    boolean existeFolio(String folio);

    Page<Folio> obtenerPorFiltro(FiltroFolio filtro);

    Folio guardar(Folio folio);
}