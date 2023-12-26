package com.nova.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
public class ReportesAreaDto implements Serializable {
    AreaDto area;
    List<ReporteDto> reportes;
}