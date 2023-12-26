package com.nova.mapper;

import com.nova.dto.AreaDto;
import com.nova.model.Area;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Area partialUpdate(AreaDto areaDto, @MappingTarget Area area);

    List<AreaDto> toDto(List<Area> area);
}