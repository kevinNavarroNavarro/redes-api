package com.APIProject.apiProject.controller;

import com.APIProject.apiProject.converter.Tipo_UnidadRestConverter;
import com.APIProject.apiProject.domain.business.TipoUnidad;
import com.APIProject.apiProject.dto.Tipo_UnidadDTO;
import com.APIProject.apiProject.service.Tipo_UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Tipo_Unidades")
@CrossOrigin
public class Tipo_UnidadesController {

    @Autowired
    private Tipo_UnidadService service;

    @Autowired
    private Tipo_UnidadRestConverter converter;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Tipo_UnidadDTO.Response findById(
            @PathVariable("id") String id) {
        return converter.toResponse(service.find(Integer.parseInt(id)));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Tipo_UnidadDTO.Response save(@RequestBody Tipo_UnidadDTO.Request unidad) {
        return converter.toResponse(service.save(converter.fromRequest(unidad)));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Tipo_UnidadDTO.Response update(@PathVariable("id") String id,
                                        @RequestBody Tipo_UnidadDTO.Request  unidad) {
        TipoUnidad toUpdate = converter.fromRequest(unidad);
        toUpdate.setID_Tipo_unidad(Integer.parseInt(id));
        return converter.toResponse(service.update(toUpdate));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        service.delete(Integer.parseInt(id));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Tipo_UnidadDTO.Response> findAll() {
        return service.findAll().stream().map(it -> converter.toResponse(it))
                .collect(Collectors.toList());
    }
}
