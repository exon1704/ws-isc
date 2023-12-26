package com.nova.repository;

import com.nova.model.Unidad;
import com.nova.projections.UnidadInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadRepository extends JpaRepository<Unidad, Long> {
    List<UnidadInfo> findBy();

}