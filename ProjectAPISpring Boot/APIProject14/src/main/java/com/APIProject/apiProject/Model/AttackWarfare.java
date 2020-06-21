package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.Warfare;

import java.util.ArrayList;
import java.util.List;

public class AttackWarfare {
    DeadUnit deadUnit;
    StolenResources stolenResources;

    public List<Warfare> AttackGuerrilla (Warfare attacker, Warfare attacked){
        stolenResources = new StolenResources();
        deadUnit = new DeadUnit();


        Integer indexOffense = ((attacker.getAssault()*80)+(attacker.getEngineer()*30)+(attacker.getTank()*500));
        Integer indexDefense = ((attacked.getAssault()*20)+(attacked.getEngineer()*70)+(attacked.getTank()*20)+(attacked.getBunker()*600));
        Double TotalPower = Double.parseDouble(""+indexOffense+indexDefense);

        Double aD = indexOffense/TotalPower;
        Double Ai= aD+0.1;

        Double oD = indexDefense/TotalPower;
        Double Di = oD+0.1;

        if(Ai>=Di){// Si gana el atacante
            if (Ai>Di) {
                attacker.setWins(attacker.getWins() + 1);
            }
            deadUnit.DeadUnitAttacked(attacker,attacked);
            deadUnit.DeadUnitAttacker(attacker,attacked);
            return stolenResources.StolenResources(attacker,attacked);
        }else { // Si el atacado tiene mas defensa
            attacked.setWins(attacked.getWins()+1);
            deadUnit.DeadUnitAttacker(attacker,attacked);
            deadUnit.DeadUnitAttacked(attacker,attacked);
            List<Warfare> warfares = new ArrayList<>();
            warfares.add(attacker);
            warfares.add(attacked);
            return warfares;
        }

    }
}
