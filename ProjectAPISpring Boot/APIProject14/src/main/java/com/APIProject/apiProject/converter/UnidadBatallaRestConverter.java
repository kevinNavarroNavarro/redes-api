package com.APIProject.apiProject.converter;

import com.APIProject.apiProject.domain.business.UnidadBatalla;
import com.APIProject.apiProject.dto.Unidades_BatallaDTO;
import com.APIProject.apiProject.service.GuerrillaService;
import com.APIProject.apiProject.service.Tipo_UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class UnidadBatallaRestConverter implements RestConverter<UnidadBatalla, Unidades_BatallaDTO.Response,
        Unidades_BatallaDTO.Request> {

    @Autowired
    GuerrillaService guerrillaService = new GuerrillaService();

    @Autowired
    Tipo_UnidadService tipo_unidadService = new Tipo_UnidadService();

    @Override
    public Unidades_BatallaDTO.Response toResponse(UnidadBatalla entity) {
        Unidades_BatallaDTO.Response dto = new Unidades_BatallaDTO.Response();
        dto.setID_unidades(entity.getID_unidades());
        dto.setGuerrilla(entity.getGuerrilla().getID_Guerrilla_Usuario());
        if (dto.getUnidades() != null) {
            dto.setUnidades(new ArrayList<>());
            dto.getUnidades().addAll(entity.getUnidadesBatalla().stream()
                    .map(it -> tipo_unidadService.find(it.getID_Tipo_unidad()))
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    @Override
    public UnidadBatalla fromRequest(Unidades_BatallaDTO.Request dto) {
        UnidadBatalla entity = new UnidadBatalla();
        entity.setID_unidades(dto.getID_unidades());
        entity.setGuerrilla(guerrillaService.find(dto.getGuerrilla()));
        if (entity.getUnidadesBatalla() != null) {
            entity.setUnidadesBatalla(new ArrayList<>());
            entity.getUnidadesBatalla().addAll(dto.getTipo_unidades().stream()
                    .map(it -> tipo_unidadService.find(it))
                    .collect(Collectors.toList()));
        }
        return entity;
    }
}
