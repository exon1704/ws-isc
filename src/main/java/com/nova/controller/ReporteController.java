package com.nova.controller;


import com.nova.dto.ReportesAreaDto;
import com.nova.exception.reporte.ReporteException;
import com.nova.mapper.ReporteMapper;
import com.nova.model.util.ReportesArea;
import com.nova.service.reporte.ReporteService;
import com.nova.toolkit.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reporte")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;
    @Autowired
    private ReporteMapper reporteMapper;

    @GetMapping("/reporte-areas")
    public ResponseEntity<ApiResponse> getAll() {
        try {
            List<ReportesArea> reportesAreas = reporteService.obtenerPorAreas();
            if (reportesAreas.isEmpty()) {
                return ResponseEntity.ok(ApiResponse.builder().code(200).message("Sin elementos").build());
            } else {
                List<ReportesAreaDto> dtoList = reporteMapper.toReportesAreaDtos(reportesAreas);
                return ResponseEntity.ok(ApiResponse.builder().data(dtoList).size(dtoList.size()).build());
            }
        } catch (Exception e) {
            System.out.print(e);
            throw new ReporteException("Error al recuperar los reportes agrupados por área", e);
        }
    }
}