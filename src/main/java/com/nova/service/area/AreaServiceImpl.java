package com.nova.service.area;


import com.nova.model.Area;
import com.nova.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> obtenerTodo() {
        return areaRepository.findAll();
    }
}