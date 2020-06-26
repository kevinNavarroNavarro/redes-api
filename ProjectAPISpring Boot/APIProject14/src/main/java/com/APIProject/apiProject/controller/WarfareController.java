package com.APIProject.apiProject.controller;

import com.APIProject.apiProject.Model.AttackWarfare;
import com.APIProject.apiProject.Model.BuyUnit;
import com.APIProject.apiProject.Model.DecideRanking;
import com.APIProject.apiProject.Model.ResultWarfare;
import com.APIProject.apiProject.converter.WarfareRestConverter;
import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.dto.WarfareDTO;
import com.APIProject.apiProject.service.WarfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    DecideRanking decideRanking;
    BuyUnit buyUnit;

    static ResultWarfare resultWarfareAttacker;
    static ResultWarfare resultWarfareAttacked;

    @RequestMapping(path = "/{guerrillaName}", method = RequestMethod.GET)
    public WarfareDTO.Response findByWarfareName(
            @PathVariable ("guerrillaName") String warfare) {
        List<Warfare> warfareList = service.findByWarfareName(warfare);
        return converter.toResponse(warfareList.get(0));
    }

    @RequestMapping(path = "/{guerrillaName}", method = RequestMethod.POST)
    public WarfareDTO.Response save (@PathVariable("guerrillaName") String warfareName,
                                     @RequestBody WarfareDTO.Request warfare){
        return converter.toResponse(service.save(converter.fromRequest(warfare)));
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<WarfareDTO.Response> find(@RequestParam(value="faction",required=false) String faction,
                                             @RequestParam(value="email",required=false) String email,
                                             @RequestParam(value="name",required=false) String name) {

        if(faction==null && email==null){
            return service.findByWarfareName(name).stream().map(it -> converter.toResponse(it))
                    .collect(Collectors.toList());
        }else if(name==null && email==null){
            return service.findByFaction(faction).stream().map(it -> converter.toResponse(it))
                .collect(Collectors.toList());
        }else if(name==null && faction==null){
            return service.findByEmail(email).stream().map(it -> converter.toResponse(it))
                    .collect(Collectors.toList());
        }else if(name==null){
            return service.findByEmail(email).stream().map(it -> converter.toResponse(it))
                    .collect(Collectors.toList());
        }else if(email==null){
            return service.findByWarfareName(name).stream().map(it -> converter.toResponse(it))
                    .collect(Collectors.toList());
        }else{
            return service.findByWarfareName(name).stream().map(it -> converter.toResponse(it))
                    .collect(Collectors.toList());
        }
    }

    // Metodo de actualizar listo
    @RequestMapping(path = "/{guerrillaName}/units", method = RequestMethod.PUT)
    public WarfareDTO.Response buyUnits(@PathVariable("guerrillaName") String warfareName,
                                        @RequestBody WarfareDTO.RequestUnits warfare) {
        Warfare toUpdate = converter.fromRequestUnits(warfare,warfareName);
        buyUnit= new BuyUnit();
        toUpdate.setWarfareName(warfareName);
        toUpdate=buyUnit.BuyUnit(warfare, warfareName, service);
        return converter.toResponse(service.update(toUpdate));
    }

    @RequestMapping(path = "/attack/{guerrillaName}", method = RequestMethod.POST)
    public List<WarfareDTO.ResponseWarfare> attackGuerrillas(@PathVariable("guerrillaName") String warfareName,
                                                      @RequestParam(value="guerrillaSrc") String warfareSrc){
        attackWarfare = new AttackWarfare();
        decideRanking= new DecideRanking();
        List<WarfareDTO.ResponseWarfare> responseWarfares = new ArrayList();

        List<Warfare> warfareList;
        warfareList = service.findByWarfareName(warfareName);
        Warfare attacker = warfareList.get(0);
        warfareList = service.findByWarfareName(warfareSrc);
        Warfare attacked = warfareList.get(0);


        resultWarfareAttacker = new ResultWarfare();
        resultWarfareAttacked = new ResultWarfare();

        List<Warfare> responses = attackWarfare.AttackGuerrilla(attacker, attacked,resultWarfareAttacker,resultWarfareAttacked);
        responseWarfares.add(converter.toResponseWarfare(responses.get(0), resultWarfareAttacker));
        responseWarfares.add(converter.toResponseWarfare(responses.get(1), resultWarfareAttacked));
        decideRanking.DecideRanking(responses.get(0));
        decideRanking.DecideRanking(responses.get(1));
        service.update(responses.get(0));
        service.update(responses.get(1));

        return responseWarfares;
    }
}