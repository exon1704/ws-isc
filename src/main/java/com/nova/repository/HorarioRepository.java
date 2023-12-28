package com.nova.repository;

import com.nova.model.Horario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @EntityGraph(attributePaths = {"operatividad"})
    Collection<Horario> findByIdUnidadOrderByOperatividad_IdAsc(Integer idUnidad);
}