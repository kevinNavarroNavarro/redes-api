package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.Warfare;

public class DeadUnit {

    // Se determinan las muertes de las unidades del atacado al perder
    public Warfare DeadUnitAttacked(Warfare attacker, Warfare attacked, ResultWarfare resultado){

        //Unidades de Asalto
        //Se calculan los valores de defensa y ataque para las unidades de asalto
        Double defenseAssault = Double.parseDouble(attacked.getAssault()*20+"");
        Double assaultWinnerDamage = ((attacker.getAssault()*0.5)+(attacker.getEngineer()*0.3)+(attacker.getTank()*5));

        if(defenseAssault>assaultWinnerDamage){
            Double resultAttacker = defenseAssault-assaultWinnerDamage;
            Integer unitsAlive= (int) Math.floor(resultAttacker/20);
            resultado.getArmy().setAssault(unitsAlive-attacked.getAssault());
            attacked.setAssault(unitsAlive);
        }else{
            resultado.getArmy().setAssault(-attacked.getAssault());
            attacked.setAssault(0);
        }

        //Ingenieros
        //Se calculan los valores de defensa y ataque para los ingenieros
        Double defenseEngineer = Double.parseDouble(attacked.getEngineer()*70+"");
        Double engineerWinnerDamage = ((attacker.getAssault()*0.8)+(attacker.getEngineer()*0.5)+(attacker.getTank()*5));

        if(defenseEngineer>engineerWinnerDamage){
            Double resultAttacker = defenseEngineer-engineerWinnerDamage;
            Integer unitsAlive= (int) Math.floor(resultAttacker/70);
            resultado.getArmy().setEngineer(unitsAlive-attacked.getEngineer());
            attacked.setEngineer(unitsAlive);
        }else{
            resultado.getArmy().setEngineer(-attacked.getEngineer());
            attacked.setEngineer(0);
        }

        // Tanques
        //Se calculan los valores de defensa y ataque para los tanques
        Double defenseTanks = Double.parseDouble(attacked.getTank()*20+"");
        Double TanksWinnerDamage = ((attacker.getAssault()*0.1)+(attacker.getEngineer()*0.9)+(attacker.getTank()*0.6));

        if(defenseTanks>TanksWinnerDamage){
            Double resultAttacker = defenseTanks-TanksWinnerDamage;
            Integer unitsAlive= (int) Math.floor(resultAttacker/20);
            resultado.getArmy().setTank(unitsAlive-attacked.getTank());
            attacked.setTank(unitsAlive);
        }else{
            resultado.getArmy().setTank(-attacked.getTank());
            attacked.setTank(0);
        }

        // Bunkers
        //Se calculan los valores de defensa y ataque para los tanques
        Double defenseBunkers = Double.parseDouble(attacked.getBunker()*600+"");
        Double BunkerWinnerDamage = ((attacker.getAssault()*0.05)+(attacker.getEngineer()*0.9)+(attacker.getTank()*1));

        if(defenseBunkers>BunkerWinnerDamage){
            Double resultAttacker = defenseBunkers-BunkerWinnerDamage;
            Integer unitsAlive= (int) Math.floor(resultAttacker/600);
            resultado.getBuildings().setBunker(unitsAlive-attacked.getBunker());
            attacked.setBunker(unitsAlive);
        }else{
            resultado.getBuildings().setBunker(-attacked.getBunker());
            attacked.setBunker(0);
        }
        return attacked;
    }


    // Se determinan las muertes de las unidades del equipo atacante al perder
    public Warfare DeadUnitAttacker(Warfare attacker, Warfare attacked, ResultWarfare resultado){

        //Unidades de Asalto
        //Se calculan los valores de defensa y ataque para las unidades de asalto
        Double defenseAssault = Double.parseDouble(attacker.getAssault()*20+"");
        Double assaultWinnerDamage = ((attacked.getAssault()*0.5)+(attacked.getEngineer()*0.3)+(attacked.getTank()*5)+
                attacked.getBunker()*5);

        if(defenseAssault>assaultWinnerDamage){
            Double resultAttacker = defenseAssault-assaultWinnerDamage;
            Integer unitsAlive= (int) Math.floor(resultAttacker/20);
            resultado.getArmy().setAssault(unitsAlive-attacker.getAssault());
            attacker.setAssault(unitsAlive);
        }else{
            resultado.getArmy().setAssault(-attacker.getAssault());
            attacker.setAssault(0);
        }

        //Ingenieros
        //Se calculan los valores de defensa y ataque para los ingenieros
        Double defenseEngineer = Double.parseDouble(attacker.getEngineer()*70+"");
        Double engineerWinnerDamage = ((attacked.getAssault()*0.8)+(attacked.getEngineer()*0.5)+(attacked.getTank()*5)+
                attacked.getBunker()*5);

        if(defenseEngineer>engineerWinnerDamage){
            Double resultAttacker = defenseEngineer-engineerWinnerDamage;
            Integer unitsAlive= (int) Math.floor(resultAttacker/70);
            resultado.getArmy().setEngineer(unitsAlive-attacker.getEngineer());
            attacker.setEngineer(unitsAlive);
        }else{
            resultado.getArmy().setEngineer(-attacker.getEngineer());
            attacker.setEngineer(0);
        }

        // Tanques
        //Se calculan los valores de defensa y ataque para los tanques
        Double defenseTanks = Double.parseDouble(attacker.getTank()*20+"");
        Double TanksWinnerDamage = ((attacked.getAssault()*0.1)+(attacked.getEngineer()*0.9)+(attacked.getTank()*0.6)+
                attacked.getBunker()*0.9);

        if(defenseTanks>TanksWinnerDamage){
            Double resultAttacker = defenseTanks-TanksWinnerDamage;
            Integer unitsAlive= (int) Math.floor(resultAttacker/20);
            resultado.getArmy().setTank(unitsAlive-attacker.getTank());
            attacker.setTank(unitsAlive);
        }else{
            resultado.getArmy().setTank(-attacker.getTank());
            attacker.setTank(0);
        }

        // Bunkers
        //Se calculan los valores de defensa y ataque para los tanques
        Double defenseBunkers = Double.parseDouble(attacker.getBunker()*600+"");
        Double BunkerWinnerDamage = ((attacked.getAssault()*0.05)+(attacked.getEngineer()*0.9)+(attacked.getTank()*1));

        if(defenseBunkers>BunkerWinnerDamage){
            Double resultAttacker = defenseBunkers-BunkerWinnerDamage;
            Integer unitsAlive= (int) Math.floor(resultAttacker/600);
            resultado.getBuildings().setBunker(unitsAlive-attacker.getBunker());
            attacked.setBunker(unitsAlive);
        }else{
            resultado.getBuildings().setBunker(-attacker.getBunker());
            attacker.setBunker(0);
        }
        return attacked;
    }
}
