package com.APIProject.apiProject.converter;

import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.dto.WarfareDTO;
import com.APIProject.apiProject.service.WarfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarfareRestConverter implements RestConverter<Warfare, WarfareDTO.Response, WarfareDTO.Request, WarfareDTO.RequestUnits> {

    @Autowired
    WarfareService warfareService;

    @Override
    public WarfareDTO.Response toResponse(Warfare entity) {
        WarfareDTO.Response dto = new WarfareDTO.Response();
        dto.setWarfareName(entity.getWarfareName());
        dto.setEmail(entity.getEmail());
        dto.setFaction(entity.getFaction());
        dto.setRank(entity.getRank());
        dto.setWins(entity.getWins());
        dto.setOil(entity.getOil());
        dto.setMoney(entity.getMoney());
        dto.setPeople(entity.getPeople());
        dto.setAssault(entity.getAssault());
        dto.setEngineer(entity.getEngineer());
        dto.setTank(entity.getTank());
        dto.setBunker(entity.getBunker());
        return dto;
    }

    @Override
    public Warfare fromRequest(WarfareDTO.Request dto) {
        Warfare entity = new Warfare();
        entity.setWarfareName(dto.getWarfareName());
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
        Warfare warfare = warfareService.findByWarfareName(warfareName);
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
