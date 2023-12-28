package com.nova.mapper;

import com.nova.dto.folio.FolioDto;
import com.nova.dto.folio.FolioRegistroDTO;
import com.nova.model.Folio;
import com.nova.projections.FolioSimple;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {ReporteMapper.class, EstadoReporteMapper.class})
public interface FolioMapper {

    List<FolioDto> toDtos(List<Folio> folios);

    Folio toEntity(FolioRegistroDTO folioRegistroDTO);
}