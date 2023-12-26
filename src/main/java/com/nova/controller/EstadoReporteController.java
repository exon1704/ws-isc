package com.nova.controller;

import com.nova.mapper.EstadoReporteMapper;
import com.nova.model.EstadoReporte;
import com.nova.service.estado_reporte.EstadoReporteService;
import com.nova.toolkit.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estado")
public class EstadoReporteController {

    @Autowired
    private EstadoReporteService service;
    @Autowired
    private EstadoReporteMapper mapper;

    @GetMapping("/estados")
    public ResponseEntity<ApiResponse> getAll() {
        List<EstadoReporte> list = service.obtenerTodo();
        if (list.isEmpty()) {
            return ResponseEntity.ok(ApiResponse.builder().message("Sin registros").code(HttpStatus.NO_CONTENT.value()).build());
        } else {
            return ResponseEntity.ok(ApiResponse.builder().data(mapper.toDtos(list))
                    .code(HttpStatus.OK.value())
                    .size(list.size()).build());
        }
    }
}