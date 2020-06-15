package com.APIProject.apiProject.converter;

import com.APIProject.apiProject.domain.business.TipoUnidad;
import com.APIProject.apiProject.dto.Tipo_UnidadDTO;
import com.APIProject.apiProject.service.UnidadBatallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tipo_UnidadRestConverter implements RestConverter<TipoUnidad, Tipo_UnidadDTO.Response, Tipo_UnidadDTO.Request> {

    @Autowired
    UnidadBatallaService unidades_batallaService = new UnidadBatallaService();

    @Override
    public Tipo_UnidadDTO.Response toResponse(TipoUnidad request) {
        Tipo_UnidadDTO.Response entity = new Tipo_UnidadDTO.Response();
        entity.setUnidad_batalla(request.getUnidadBatalla().getID_unidades());
        entity.setID_Tipo_unidad(request.getID_Tipo_unidad());
        entity.setTotal_unidades(request.getTotal_unidades());
        entity.setPillaje(request.getPillaje());
        entity.setDescription(request.getDescription());
        entity.setDefensa(request.getDefensa());
        entity.setAtaque(request.getAtaque());
        entity.setCosto_RH(request.getCosto_RH());
        entity.setCosto_petroleo(request.getCosto_petroleo());
        entity.setCosto_Dinero(request.getCosto_Dinero());
        return entity;
    }

    @Override
    public TipoUnidad fromRequest(Tipo_UnidadDTO.Request request) {
        TipoUnidad entity = new TipoUnidad();
        entity.setUnidadBatalla(unidades_batallaService.find(request.getUnidadesBatalla()));
        entity.setTotal_unidades(request.getTotal_unidades());
        entity.setAtaque(request.getAtaque());
        entity.setCosto_Dinero(request.getCosto_Dinero());
        entity.setCosto_petroleo(request.getCosto_petroleo());
        entity.setCosto_RH(request.getCosto_RH());
        entity.setDefensa(request.getDefensa());
        entity.setDescription(request.getDescription());
        entity.setPillaje(request.getPillaje());
        entity.setID_Tipo_unidad(request.getID_Tipo_unidad());
        return entity;
    }
}
