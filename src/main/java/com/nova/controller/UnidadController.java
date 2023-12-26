package com.nova.controller;

import com.nova.dto.GeneralesDTO;
import com.nova.dto.HorarioDto;
import com.nova.dto.UnidadContactoDto;
import com.nova.mapper.HorarioMapper;
import com.nova.mapper.UnidadContactoMapper;
import com.nova.model.Horario;
import com.nova.model.UnidadContacto;
import com.nova.projections.UnidadInfo;
import com.nova.service.unidad.UnidadService;
import com.nova.toolkit.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("unidad")
public class UnidadController {
    @Autowired
    private UnidadService unidadService;
    @Autowired
    private UnidadContactoMapper contactoMapper;
    @Autowired
    private HorarioMapper horarioMapper;

    @GetMapping("/unidades")
    public ResponseEntity<ApiResponse> obtenerUnidadesSimples() {
        List<UnidadInfo> list = this.unidadService.obtenerTodoSimple();
        if (list.isEmpty()) {
            return ResponseEntity.ok(ApiResponse.builder()
                    .message("No hay registros disponibles")
                    .code(HttpStatus.NO_CONTENT.value())
                    .build());
        } else {
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(list)
                    .code(200)
                    .size(list.size())
                    .build());
        }
    }

    @GetMapping("/generales")
    public ResponseEntity<ApiResponse> generales(@RequestParam("id") Integer idUnidad) {
        Optional<UnidadContacto> unidadContactoOptional = unidadService.obtenerContacto(idUnidad);
        Collection<Horario> horarios = unidadService.obtenerHorarios(idUnidad);
        UnidadContactoDto contactoDto;
        Collection<HorarioDto> horario;
        if (unidadContactoOptional.isEmpty()) {
            return ResponseEntity.ok(ApiResponse.builder()
                    .code(HttpStatus.NO_CONTENT.value())
                    .data(null)
                    .message("No se encontraron resultados")
                    .build());
        } else {
            contactoDto = contactoMapper.toDto(unidadContactoOptional.get());
            horario = horarioMapper.toDtos(horarios);
            GeneralesDTO generales = new GeneralesDTO(contactoDto, horario);
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(generales)
                    .code(200)
                    .build());
        }
    }
}