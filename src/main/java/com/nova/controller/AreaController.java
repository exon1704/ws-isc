package com.nova.controller;

import com.nova.dto.AreaDto;
import com.nova.mapper.AreaMapper;
import com.nova.service.area.AreaService;
import com.nova.toolkit.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private AreaService areaService;
    @Autowired
    private AreaMapper areaMapper;

    @GetMapping("/areas")
    public ResponseEntity<ApiResponse> obtenerTodos() {
        List<AreaDto> list = areaMapper.toDto(areaService.obtenerTodo());
        if (list.isEmpty()) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(5, TimeUnit.HOURS))
                    .body(ApiResponse.builder().message("Sin resultados").code(200).build());
        } else {
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(list)
                    .size(list.size())
                    .code(200)
                    .build());
        }
    }
}