package com.nova.service.folio;

import com.nova.model.Folio;
import com.nova.projections.FolioInfo;
import com.nova.toolkit.FiltroFolio;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface FolioService {
    Optional<FolioInfo> obtenerPorFolio(String folio);

    boolean existeFolio(String folio);

    Page<Folio> obtenerPorFiltro(FiltroFolio filtro);

    Folio guardar(Folio folio);
}