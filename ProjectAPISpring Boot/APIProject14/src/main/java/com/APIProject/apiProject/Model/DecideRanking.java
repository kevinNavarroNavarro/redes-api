package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.Warfare;

//Calcula el puntaje de cada usuario, (Promedio de Indices) + (Promedio de Recursos) + Wins()*100
public class DecideRanking {
    public void DecideRanking(Warfare warfare){
        warfare.setRank(0);
        warfare.setRank(Integer.parseInt(""+((warfare.getAssault()+warfare.getEngineer()+
                warfare.getBunker()+warfare.getTank()/4)+
                ((warfare.getMoney()+warfare.getOil())/2)+(warfare.getWins()*100))));
    }
}
