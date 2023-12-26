package com.nova.controller;

import com.nova.dto.FolioDto;
import com.nova.mapper.FolioMapper;
import com.nova.model.EstadoReporte;
import com.nova.model.Folio;
import com.nova.service.folio.FolioService;
import com.nova.toolkit.ApiResponse;
import com.nova.toolkit.FiltroFolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("folio")
public class FolioController {

    @Autowired
    private FolioService folioService;
    @Autowired
    private FolioMapper folioMapper;

    @PostMapping("/guardar")
    public ResponseEntity<ApiResponse> guardar(@RequestBody FolioDto folio) {
        if (folioService.existeFolio(folio.getFolio())) {
            throw new DataIntegrityViolationException(
                    "El folio ya se encuentra asignado a otro reporte");
        } else {
            Folio objet = folioMapper.toEntity(folio);
            objet.setFecha(LocalDateTime.now());
            if (objet.getEstado() == null) {
                objet.setEstado(new EstadoReporte());
            }
            folioService.guardar(objet);
            return ResponseEntity.ok(ApiResponse.builder()
                    .message("Folio de seguimiento: " + objet.getFolio())
                    .code(200)
                    .build());
        }
    }

    @GetMapping("/folio")
    public ResponseEntity<ApiResponse> obtenerPorFolio(@RequestParam("folio") String folio) {
        return folioService.obtenerPorFolio(folio)
                .map(data -> ResponseEntity.ok(ApiResponse.builder()
                        .data(data)
                        .code(200)
                        .build()))
                .orElse(ResponseEntity.ok(ApiResponse.builder()
                        .code(HttpStatus.NO_CONTENT.value())
                        .data(null)
                        .message("No se encontraron resultados")
                        .build()));
    }

    @GetMapping("/filtro")
    public ResponseEntity<ApiResponse> obtenerPorFiltro(@RequestParam("pagina") int pagina,
                                                        @RequestParam("filas") int filas,
                                                        @RequestParam(value = "unidad", required = false) Integer idUnidad,
                                                        @RequestParam(value = "estado", required = false) Integer idEstado,
                                                        @RequestParam(value = "area", required = false) Integer idArea,
                                                        @RequestParam("fecha") LocalDateTime fecha) {


        FiltroFolio filtro = new FiltroFolio(fecha, idEstado, idArea, filas, pagina, idUnidad);
        Page<Folio> list = folioService.obtenerPorFiltro(filtro);
        if (list.isEmpty()) {
            return ResponseEntity.ok(ApiResponse.builder().message("Sin resultados").code(HttpStatus.NO_CONTENT.value()).build());
        } else {
            return ResponseEntity.ok(ApiResponse.builder()
                    .page(Map.
                            of("numberOfElements", list.getNumberOfElements(),
                                    "totalPage", list.getTotalPages(),
                                    "totalElements", list.getTotalElements(),
                                    "number", list.getNumber()
                            ))
                    .data(folioMapper.toDtos(list.getContent())).code(HttpStatus.OK.value()).build());
        }
    }
}