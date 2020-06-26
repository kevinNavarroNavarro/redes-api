package com.APIProject.apiProject.converter;

import com.APIProject.apiProject.Model.ResultWarfare;
import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.dto.WarfareDTO;
import com.APIProject.apiProject.service.WarfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarfareRestConverter implements RestConverter<Warfare, WarfareDTO.Response, WarfareDTO.Request, WarfareDTO.RequestUnits> {

    @Autowired
    WarfareService warfareService;

    @Override
    public WarfareDTO.Response toResponse(Warfare entity) {
        WarfareDTO.Response dto = new WarfareDTO.Response();
        dto.setName(entity.getWarfareName());
        dto.setEmail(entity.getEmail());
        dto.setFaction(entity.getFaction());
        dto.setRank(entity.getRank());
        dto.setWins(entity.getWins());
        dto.getResources().setOil(entity.getOil());
        dto.getResources().setMoney(entity.getMoney());
        dto.getResources().setPeople(entity.getPeople());
        dto.getArmy().setAssault(entity.getAssault());
        dto.getArmy().setEngineer(entity.getEngineer());
        dto.getArmy().setTank(entity.getTank());
        dto.getBuildings().setBunker(entity.getBunker());
        return dto;
    }

    @Override
    public WarfareDTO.ResponseWarfare toResponseWarfare(Warfare entity, ResultWarfare result) {
        WarfareDTO.ResponseWarfare dto = new WarfareDTO.ResponseWarfare();
        dto.setName(entity.getWarfareName());
        dto.setEmail(entity.getEmail());
        dto.setFaction(entity.getFaction());
        dto.setRank(entity.getRank());
        dto.setWins(entity.getWins());
        dto.getResources().setOil(entity.getOil());
        dto.getResources().setMoney(entity.getMoney());
        dto.getResources().setPeople(entity.getPeople());
        dto.getArmy().setAssault(entity.getAssault());
        dto.getArmy().setEngineer(entity.getEngineer());
        dto.getArmy().setTank(entity.getTank());
        dto.getBuildings().setBunker(entity.getBunker());
        dto.getResults().setName(result.getName());
        dto.getResults().getResources().setOil(result.getResources().getOil());
        dto.getResults().getResources().setPeople(result.getResources().getPeople());
        dto.getResults().getResources().setMoney(result.getResources().getMoney());
        dto.getResults().getBuildings().setBunker(result.getBuildings().getBunker());
        dto.getResults().getArmy().setAssault(result.getArmy().getAssault());
        dto.getResults().getArmy().setTank(result.getArmy().getTank());
        dto.getResults().getArmy().setEngineer(result.getArmy().getEngineer());
        return dto;
    }

    @Override
    public Warfare fromRequest(WarfareDTO.Request dto) {
        Warfare entity = new Warfare();
        entity.setWarfareName(dto.getGuerrillaName());
        entity.setEmail(dto.getEmail());
        entity.setFaction(dto.getFaction());
        entity.setRank(0);
        entity.setWins(0);
        entity.setOil(300);
        entity.setMoney(300);
        entity.setPeople(50);
        entity.setAssault(0);
        entity.setEngineer(0);
        entity.setTank(0);
        entity.setBunker(0);
        return  entity;
    }

    @Override
    public Warfare fromRequestUnits(WarfareDTO.RequestUnits dto, String warfareName) {
        List<Warfare> warfares = warfareService.findByWarfareName(warfareName);
        Warfare warfare = warfares.get(0
        );
        Warfare entity = new Warfare();
        entity.setWarfareName(warfare.getWarfareName());
        entity.setEmail(warfare.getEmail());
        entity.setFaction(warfare.getFaction());
        entity.setRank(warfare.getRank());
        entity.setWins(warfare.getWins());
        entity.setOil(warfare.getOil());
        entity.setMoney(warfare.getMoney());
        entity.setPeople(warfare.getPeople());
        entity.setAssault(warfare.getAssault());
        entity.setEngineer(warfare.getEngineer());
        entity.setTank(warfare.getTank());
        entity.setBunker(warfare.getBunker());
        return  entity;
    }


}
