package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.converter.WarfareRestConverter;
import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.dto.WarfareDTO;
import com.APIProject.apiProject.exceptions.NonSufficientFunds;
import com.APIProject.apiProject.service.WarfareService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BuyUnit {

    @Autowired
    WarfareRestConverter converter;

    DecideRanking decideRanking;

    public Warfare BuyUnit(WarfareDTO.RequestUnits dto, String warfareName, WarfareService service){
        decideRanking = new DecideRanking();
        List<Warfare> warfares = service.findByWarfareName(warfareName);
        Warfare warfare = warfares.get(0);
        //Se calcula el costo de petroleo y dinero de las unidades
        Integer unitsCostMoney = (20*dto.getArmy().getAssault())+(10*dto.getArmy().getEngineer())+(200*dto.getArmy().getTank())+ (300*dto.getBuildings().getBunker());
        Integer unitsCostOil = (25*dto.getArmy().getAssault())+(25*dto.getArmy().getEngineer())+(500*dto.getArmy().getTank())+ (200*dto.getBuildings().getBunker());
        Integer unitsCostPeople = ((dto.getArmy().getAssault()*1)+(dto.getArmy().getEngineer()*1)+(dto.getArmy().getTank()*8)+(dto.getBuildings().getBunker()*8));

        // Revisa tener el suficiente Oro y Petroleo para comprar las unidades
        if(warfare.getMoney()>= unitsCostMoney && warfare.getOil()>=unitsCostOil &&
                warfare.getPeople()>=unitsCostPeople){
            //Se toman las unidades ya existentes y se le suman a las nuevas
            warfare.setAssault(warfare.getAssault()+dto.getArmy().getAssault());
            warfare.setEngineer(warfare.getEngineer()+dto.getArmy().getEngineer());
            warfare.setTank(warfare.getTank()+dto.getArmy().getTank());
            warfare.setBunker(warfare.getBunker()+dto.getBuildings().getBunker());
            warfare.setMoney(warfare.getMoney()-unitsCostMoney);
            warfare.setOil(warfare.getOil()-unitsCostOil);
            warfare.setPeople(warfare.getPeople()-unitsCostPeople);
            decideRanking.DecideRanking(warfare);
        }else{
            throw new NonSufficientFunds("Sus recursos no son suficientes para comprar las unidades");
        }
        return warfare;
    }
}
