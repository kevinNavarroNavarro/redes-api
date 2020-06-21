package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.converter.WarfareRestConverter;
import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.dto.WarfareDTO;
import com.APIProject.apiProject.exceptions.NonSufficientFunds;
import com.APIProject.apiProject.service.WarfareService;
import org.springframework.beans.factory.annotation.Autowired;

public class BuyUnit {

    @Autowired
    WarfareRestConverter converter;

    DecideRanking decideRanking;

    public Warfare BuyUnit(WarfareDTO.RequestUnits dto, String warfareName, WarfareService service){
        decideRanking = new DecideRanking();
        Warfare warfare = service.findByWarfareName(warfareName);

        //Se calcula el costo de petroleo y dinero de las unidades
        Integer unitsCostMoney = (20*dto.getAssault())+(10*dto.getEngineer())+(200*dto.getTank())+ (300*dto.getBunker());
        Integer unitsCostOil = (25*dto.getAssault())+(25*dto.getEngineer())+(500*dto.getTank())+ (200*dto.getBunker());
        Integer unitsCostPeople = ((dto.getAssault()*1)+(dto.getEngineer()*1)+(dto.getTank()*8)+(dto.getBunker()*8));

        // Revisa tener el suficiente Oro y Petroleo para comprar las unidades
        if(warfare.getMoney()>= unitsCostMoney && warfare.getOil()>=unitsCostOil &&
                warfare.getPeople()>=unitsCostPeople){
            //Se toman las unidades ya existentes y se le suman a las nuevas
            warfare.setAssault(warfare.getAssault()+dto.getAssault());
            warfare.setEngineer(warfare.getEngineer()+dto.getEngineer());
            warfare.setTank(warfare.getTank()+dto.getTank());
            warfare.setBunker(warfare.getBunker()+dto.getBunker());
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
