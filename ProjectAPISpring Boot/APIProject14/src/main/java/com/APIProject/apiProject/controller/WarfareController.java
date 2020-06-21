package com.APIProject.apiProject.controller;

import com.APIProject.apiProject.Model.AttackWarfare;
import com.APIProject.apiProject.Model.BuyUnit;
import com.APIProject.apiProject.converter.WarfareRestConverter;
import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.dto.WarfareDTO;
import com.APIProject.apiProject.service.WarfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/guerrilla")
@CrossOrigin
public class WarfareController {

    @Autowired
    private WarfareService service;

    @Autowired
    private WarfareRestConverter converter;


    AttackWarfare attackWarfare;
    BuyUnit buyUnit;

    @RequestMapping(path = "/WarfareName/{warfareName}", method = RequestMethod.GET)
    public WarfareDTO.Response findByWarfareName(
            @PathVariable ("warfareName") String warfare) {
        return converter.toResponse(service.findByWarfareName(warfare));
    }

    @RequestMapping(path = "/email/{email}", method = RequestMethod.GET)
    public WarfareDTO.Response findByEmail(
            @PathVariable ("email") String email) {
        return converter.toResponse(service.findByEmail(email));
    }

    @RequestMapping(path = "/faction/{faction}", method = RequestMethod.GET)
    public List<WarfareDTO.Response> findByFaction(
            @PathVariable ("faction") String faction) {
        return service.findByFaction(faction).stream().map(it -> converter.toResponse(it))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public WarfareDTO.Response save (@RequestBody WarfareDTO.Request warfare){
        return converter.toResponse(service.save(converter.fromRequest(warfare)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public WarfareDTO.Response update(@RequestParam(value="warfareName") String warfareName,
                                      @RequestBody WarfareDTO.RequestUnits warfare) {
        Warfare toUpdate = converter.fromRequestUnits(warfare,warfareName);
        buyUnit= new BuyUnit();
        toUpdate.setWarfareName(warfareName);
        toUpdate=buyUnit.BuyUnit(warfare, warfareName, service);
        return converter.toResponse(service.update(toUpdate));
    }

    @RequestMapping(path = "/{warfareName}", method =  RequestMethod.DELETE)
    public void delete(@PathVariable("warfareName") String warfare) {
        service.delete(warfare);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<WarfareDTO.Response> findAll() {
        return service.findAll().stream().map(it -> converter.toResponse(it))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/{warfareName}/{warfareSrc}", method = RequestMethod.PUT)
    public List<WarfareDTO.Response> attackGuerrillas(@PathVariable("warfareName") String warfareName,
                                                      @PathVariable("warfareSrc") String warfareSrc){
        attackWarfare = new AttackWarfare();
        List<Warfare> responses =attackWarfare.AttackGuerrilla(service.findByWarfareName(warfareName),
                service.findByWarfareName(warfareSrc));
        service.update(responses.get(0));
        service.update(responses.get(1));
        return responses.stream().map(it -> converter.toResponse(it)).collect(Collectors.toList());
    }
}