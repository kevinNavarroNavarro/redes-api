package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.Warfare;
import com.APIProject.apiProject.service.WarfareService;

import java.util.ArrayList;
import java.util.List;

public class FactionProperties {

    DecideRanking decideRanking;

    // Se le asignan recursos a cada guerrilla
    public void UpdateProperties(WarfareService service){
        List<Warfare> aux= new ArrayList<>();
        List<Warfare> guerrillas= service.findAll();
        if(!guerrillas.isEmpty() || guerrillas == null) {
            for (Warfare warfare : guerrillas) {
                Warfare warfareAux = warfare;
                switch (warfare.getFaction().toLowerCase()) {
                    case "chino":
                        warfareAux.setPeople(warfare.getPeople()+10);
                        warfareAux.setOil(warfare.getOil() + 250);
                        warfareAux.setMoney(warfare.getMoney() + 250);
                        aux.add(warfareAux);
                        break;
                    case "usmc":
                        warfareAux.setPeople(warfare.getPeople()+5);
                        warfareAux.setOil(warfare.getOil() + 150);
                        warfareAux.setMoney(warfare.getMoney() + 400);
                        aux.add(warfareAux);
                        break;
                    case "mec":
                        warfare.setPeople(warfare.getPeople()+3);
                        warfareAux.setOil(warfare.getOil() + 400);
                        warfareAux.setMoney(warfare.getMoney() + 300);
                        aux.add(warfareAux);
                        break;
                    default:
                        warfareAux.setPeople(warfare.getPeople()+7);
                        warfareAux.setOil(warfare.getOil() + 200);
                        warfareAux.setMoney(warfare.getMoney() + 200);
                        aux.add(warfareAux);
                        break;
                }
            }
            Update(aux, service);
        }
    }

    // Se actualizan las guerrillas con la suma de los recursos
    private void Update(List<Warfare> warfares, WarfareService warfareService){
        decideRanking = new DecideRanking();
        for (Warfare warfare: warfares){
            decideRanking.DecideRanking(warfare);
            warfareService.update(warfare);

        }

    }

}
