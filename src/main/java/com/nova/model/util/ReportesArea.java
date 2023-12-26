package com.nova.model.util;


import com.nova.model.Area;
import com.nova.model.Reporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ReportesArea {
    private Area area;
    private List<Reporte> reportes;
}
