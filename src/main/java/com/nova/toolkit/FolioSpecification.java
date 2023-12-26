package com.nova.toolkit;

import com.nova.model.Folio;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FolioSpecification {
    public static Specification<Folio> filtrarFolio(FiltroFolio filtro) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filtro.getUnidad() != null) {
                predicates.add(criteriaBuilder.equal(root.get("unidad").get("id"), filtro.getUnidad()));
            }
            if (filtro.getEstado() != null) {
                predicates.add(criteriaBuilder.equal(root.get("estado").get("id"), filtro.getEstado()));
            }
            if (filtro.getFecha() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("fecha"), filtro.getFecha()));
            }
            if (filtro.getArea() != null) {
                predicates.add(criteriaBuilder.equal(root.get("reporte").get("area").get("id"), filtro.getArea()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}