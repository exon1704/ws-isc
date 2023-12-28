package com.nova.service.unidad;

import com.nova.model.Horario;
import com.nova.model.UnidadContacto;
import com.nova.projections.UnidadInfo;
import com.nova.repository.HorarioRepository;
import com.nova.repository.UnidadContactoRepository;
import com.nova.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadServiceImpl implements UnidadService {

    @Autowired
    private UnidadRepository unidadRepository;

    @Autowired
    private UnidadContactoRepository contactoRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    public List<UnidadInfo> obtenerTodoSimple() {
        return this.unidadRepository.findBy();
    }

    @Override
    public Optional<UnidadContacto> obtenerContacto(Integer id) {
        return contactoRepository.findById(id);
    }

    @Override
    public Collection<Horario> obtenerHorarios(Integer idUnidad) {
        return horarioRepository.findByIdUnidadOrderByOperatividad_IdAsc(idUnidad);
    }

}