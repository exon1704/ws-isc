package com.nova.mapper;


import com.nova.dto.ReporteDto;
import com.nova.dto.ReportesAreaDto;
import com.nova.model.Reporte;
import com.nova.model.util.ReportesArea;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReporteMapper {

    ReporteDto toDto(Reporte reporte);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reporte partialUpdate(ReporteDto reporteDto, @MappingTarget Reporte reporte);

    List<ReporteDto> toDto(List<Reporte> reporte);

    List<ReportesAreaDto> toReportesAreaDtos(List<ReportesArea> reportesArea);

    Reporte toEntity(ReporteDto reporteDto);
}