package com.nova.repository;

import com.nova.model.Folio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolioRepository extends JpaRepository<Folio, Long>, JpaSpecificationExecutor<Folio> {
    @EntityGraph(attributePaths = {"unidad", "reporte.area", "estado"})
    <T>
    Optional<T> findByFolio(String folio, Class<T> type);

    @Query("select (count(f) > 0) from Folio f where upper(f.folio) = upper(?1)")
    boolean existsByFolioIgnoreCase(String folio);

    @EntityGraph(attributePaths = {"unidad", "reporte.area", "estado"})
    @Override
    Page<Folio> findAll(Specification<Folio> spec, Pageable pageable);
}