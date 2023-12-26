package com.nova.mapper;

import com.nova.dto.EstadoReporteDto;
import com.nova.model.EstadoReporte;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstadoReporteMapper {
    List<EstadoReporteDto> toDtos(List<EstadoReporte> estadoReportes);
}