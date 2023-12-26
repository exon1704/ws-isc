package com.nova.service.estado_reporte;

import com.nova.model.EstadoReporte;
import com.nova.repository.EstadoReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoReporteServiceImpl implements EstadoReporteService {

    @Autowired
    private EstadoReporteRepository estadoreporteRepository;

    @Override
    public List<EstadoReporte> obtenerTodo() {
        return estadoreporteRepository.findAll();
    }
}