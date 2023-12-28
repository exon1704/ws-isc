package com.nova.service.folio;

import com.nova.model.Folio;
import com.nova.projections.FolioDetalles;
import com.nova.projections.FolioSimple;
import com.nova.repository.FolioRepository;
import com.nova.toolkit.FiltroFolio;
import com.nova.toolkit.FolioSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FolioServiceImpl implements FolioService {

    @Autowired
    private FolioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<FolioSimple> obtenerPorFolio(String folio) {
        return repository.findByFolio(folio, FolioSimple.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FolioDetalles> obtenerDetalles(String folio) {
        return repository.findByFolio(folio, FolioDetalles.class);
    }

    @Override
    public boolean existeFolio(String folio) {
        return repository.existsByFolioIgnoreCase(folio);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Folio> obtenerPorFiltro(FiltroFolio filtro) {
        Pageable pageable = PageRequest.of(filtro.getPagina(), filtro.getFilas(), Sort.by(Sort.Order.desc("fecha")));
        return repository.findAll(FolioSpecification.filtrarFolio(filtro), pageable);
    }

    @Override
    @Transactional()
    public Folio guardar(Folio folio) {
        return repository.save(folio);
    }

}