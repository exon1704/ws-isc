package com.nova.mapper;

import com.nova.dto.UnidadContactoDto;
import com.nova.model.UnidadContacto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UnidadContactoMapper {
    UnidadContactoDto toDto(UnidadContacto unidadContacto);
}