package com.nova.service.reporte;

import com.nova.model.Area;
import com.nova.model.Reporte;
import com.nova.model.util.ReportesArea;
import com.nova.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;


    @Override
    public List<ReportesArea> obtenerPorAreas() {
        List<Reporte> reportes = reporteRepository.findAll();
        Map<Area, List<Reporte>> reportesPorArea = reportes.stream()
                .collect(Collectors.groupingBy(Reporte::getArea));
        return reportesPorArea.entrySet().stream()
                .map(entry -> new ReportesArea(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}