package com.APIProject.apiProject.converter;

import com.APIProject.apiProject.domain.business.GuerrillaUsuario;
import com.APIProject.apiProject.dto.GuerrillaDTO;
import com.APIProject.apiProject.service.UnidadBatallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class GuerrillaRestConverter implements RestConverter<GuerrillaUsuario, GuerrillaDTO.Response, GuerrillaDTO.Request> {

    @Autowired
    UnidadBatallaService unidades_batallaService = new UnidadBatallaService();

    @Override
    public GuerrillaDTO.Response toResponse(GuerrillaUsuario entity) {
        GuerrillaDTO.Response dto = new GuerrillaDTO.Response();
        dto.setDinero(entity.getDinero());
        dto.setNombre(entity.getNombre());
        dto.setID_Guerrilla_Usuario(entity.getID_Guerrilla_Usuario());
        dto.setDireccion(entity.getFaccion());
        dto.setEmail(entity.getEmail());
        dto.setIndice_ataque(entity.getIndice_ataque());
        dto.setIndice_defensa(entity.getIndice_defensa());
        dto.setPetroleo(entity.getPetroleo());
        dto.setPuntaje(entity.getPuntaje());
        dto.setRecurso_humano(entity.getRecurso_humano());
        return dto;
    }

    @Override
    public GuerrillaUsuario fromRequest(GuerrillaDTO.Request dto) {
        GuerrillaUsuario entity = new GuerrillaUsuario();
        entity.setDinero(dto.getDinero());
        entity.setNombre(dto.getNombre());
        entity.setFaccion(dto.getDireccion());
        entity.setID_Guerrilla_Usuario(dto.getID_Guerrilla_Usuario());
        entity.setEmail(dto.getEmail());
        entity.setIndice_ataque(dto.getIndice_ataque());
        entity.setIndice_defensa(dto.getIndice_defensa());
        entity.setPetroleo(dto.getPetroleo());
        entity.setPuntaje(dto.getPuntaje());
        entity.setRecurso_humano(dto.getRecurso_humano());
        if (entity.getUnidad_batallas() != null) {
            entity.setUnidad_batallas(new ArrayList<>());
            entity.getUnidad_batallas().addAll(dto.getUnidades_batallas().stream()
                    .map(it -> unidades_batallaService.find(it))
                    .collect(Collectors.toList()));
        }
        return entity;
    }
}
