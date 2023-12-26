package com.nova.mapper;

import com.nova.dto.HorarioDto;
import com.nova.model.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HorarioMapper {
    Collection<HorarioDto> toDtos(Collection<Horario> horarios);
}