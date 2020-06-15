package com.APIProject.apiProject.controller;

import com.APIProject.apiProject.converter.UnidadBatallaRestConverter;
import com.APIProject.apiProject.domain.business.UnidadBatalla;
import com.APIProject.apiProject.dto.Unidades_BatallaDTO;
import com.APIProject.apiProject.service.UnidadBatallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(path="/UnidadesBatalla")
@CrossOrigin
public class UnidadBatallaController {

    @Autowired
    private UnidadBatallaService service;

    @Autowired
    private UnidadBatallaRestConverter converter;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Unidades_BatallaDTO.Response findById(
            @PathVariable("id") String id) {
        return converter.toResponse(service.find(parseInt(id)));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Unidades_BatallaDTO.Response save( @RequestBody Unidades_BatallaDTO.Request unidad) {
        return converter.toResponse(service.save(converter.fromRequest(unidad)));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Unidades_BatallaDTO.Response update( @PathVariable(value = "id", required = false) String id,
                                     @RequestBody Unidades_BatallaDTO.Request unidad) {
        UnidadBatalla toUpdate = converter.fromRequest(unidad);
        toUpdate.setID_unidades(parseInt(id));
        return converter.toResponse(service.update(toUpdate));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        service.delete(parseInt(id));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Unidades_BatallaDTO.Response> findAll() {
        return service.findAll().stream().map(it -> converter.toResponse(it))
                .collect(Collectors.toList());
    }
}
