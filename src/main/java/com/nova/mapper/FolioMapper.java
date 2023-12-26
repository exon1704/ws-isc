package com.nova.mapper;

import com.nova.dto.FolioDto;
import com.nova.model.Folio;
import com.nova.projections.FolioInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {ReporteMapper.class, EstadoReporteMapper.class})
public interface FolioMapper {
    FolioDto toDto(FolioInfo folio);

    List<FolioDto> toDtos(List<Folio> folios);

    Folio toEntity(FolioDto folioDto);
}