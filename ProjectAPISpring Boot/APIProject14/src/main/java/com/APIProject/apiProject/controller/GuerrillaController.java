package com.APIProject.apiProject.controller;

import com.APIProject.apiProject.converter.GuerrillaRestConverter;
import com.APIProject.apiProject.domain.business.GuerrillaUsuario;
import com.APIProject.apiProject.dto.GuerrillaDTO;
import com.APIProject.apiProject.service.GuerrillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/Guerrilla_Usuario")
@CrossOrigin
public class GuerrillaController {

    @Autowired
    private GuerrillaService service;

    @Autowired
    private GuerrillaRestConverter converter;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public GuerrillaDTO.Response findById(
            @PathVariable ("id") String id) {
        return converter.toResponse(service.find(Integer.parseInt(id)));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public GuerrillaDTO.Response save (@RequestBody GuerrillaDTO.Request guerrilla){
        return converter.toResponse(service.save(converter.fromRequest(guerrilla)));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public GuerrillaDTO.Response update(@PathVariable("id") Integer id,
                                    @RequestBody GuerrillaDTO.Request guerrilla) {
        GuerrillaUsuario toUpdate = converter.fromRequest(guerrilla);
        toUpdate.setID_Guerrilla_Usuario(id);
        return converter.toResponse(service.update(toUpdate));
    }

    @RequestMapping(path = "/{id}", method =  RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        service.delete(Integer.parseInt(id));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<GuerrillaDTO.Response> findAll() {
        return service.findAll().stream().map(it -> converter.toResponse(it))
                .collect(Collectors.toList());
    }
}

