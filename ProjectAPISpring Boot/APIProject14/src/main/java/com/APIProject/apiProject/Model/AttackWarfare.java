package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.Warfare;

import java.util.ArrayList;
import java.util.List;

public class AttackWarfare {
    DeadUnit deadUnit;
    StolenResources stolenResources;

    public List<Warfare> AttackGuerrilla (Warfare attacker, Warfare attacked,ResultWarfare resultAttacker,
                                          ResultWarfare resultAttacked){
        stolenResources = new StolenResources();
        deadUnit = new DeadUnit();

        Warfare newAttacker = attacker;
        Warfare newAttacked = attacked;

        resultAttacker.setName(attacker.getWarfareName());
        resultAttacked.setName(attacked.getWarfareName());

        Integer indexOffense = ((newAttacker.getAssault()*80)+(newAttacker.getEngineer()*30)+(newAttacker.getTank()*500));
        Integer indexDefense = ((newAttacked.getAssault()*20)+(newAttacked.getEngineer()*70)+(newAttacked.getTank()*20)+(newAttacked.getBunker()*600));
        Double TotalPower = Double.parseDouble(""+indexOffense+indexDefense);

        Double aD = indexOffense/TotalPower;
        Double Ai= aD+0.1;

        Double oD = indexDefense/TotalPower;
        Double Di = oD+0.1;


        if(Ai>=Di){// Si gana el atacante
            if (Ai>Di) {
                newAttacker.setWins(newAttacker.getWins() + 1);
            }
            deadUnit.DeadUnitAttacked(newAttacker,newAttacked, resultAttacked);
            deadUnit.DeadUnitAttacker(newAttacker,newAttacked, resultAttacker);
            return  stolenResources.StolenResources(newAttacker,newAttacked, resultAttacker, resultAttacked);

        }else { // Si el atacado tiene mas defensa
            newAttacked.setWins(newAttacked.getWins()+1);
            deadUnit.DeadUnitAttacker(newAttacker,newAttacked, resultAttacker);
            deadUnit.DeadUnitAttacked(newAttacker,newAttacked, resultAttacked);
            List<Warfare> warfares = new ArrayList<>();
            warfares.add(newAttacker);
            warfares.add(newAttacked);
            return warfares;
        }

    }
}
