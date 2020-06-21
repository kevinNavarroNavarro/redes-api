package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.Warfare;

import java.util.ArrayList;
import java.util.List;

public class StolenResources {

    DecideRanking decideRanking;

    //Permite calcular el total de recursos que se le pueden robar al enemigo
    public List<Warfare> StolenResources(Warfare attacker, Warfare attacked){
        decideRanking = new DecideRanking();

        // Se calcula el valor de los datos del pillaje
        Integer totalPillage = ((attacker.getAssault()*25)+(attacker.getEngineer()*60)+(attacker.getTank()*200));
        Integer oilPillage = (totalPillage *60)/100;
        Integer moneyPillage = (totalPillage*40)/100;

        // Se confirma que tenga recursos que robar
        if(attacked.getMoney()!=0 || attacked.getOil()!=0){
            Integer newMoneyPillage = moneyPillage;
            Integer newOilPillage = oilPillage;
            moneyPillage=moneyPillage-attacked.getMoney();
            oilPillage=oilPillage-attacked.getOil();

            if(moneyPillage<=0 && oilPillage<=0){//Tiene suficiente Oro y Petroleo
                attacker.setMoney(attacker.getMoney()+newMoneyPillage);
                attacked.setMoney(attacked.getMoney()-newMoneyPillage);
                attacker.setOil(attacker.getOil()+newOilPillage);
                attacked.setOil(attacked.getOil()-newOilPillage);
            }
            else if(moneyPillage>0 && oilPillage<=0){//No tiene suficiente Oro pero petroleo si
                attacker.setMoney(attacker.getMoney()+attacked.getMoney());
                attacked.setMoney(0);
                oilPillage=0;
                oilPillage= newOilPillage+moneyPillage;
                newOilPillage=oilPillage;
                oilPillage=oilPillage-attacked.getOil();
                if(oilPillage<0){
                    attacker.setOil(attacker.getOil()+newOilPillage);
                    attacked.setOil(attacked.getOil()-newOilPillage);
                }else{
                    attacker.setOil(attacker.getOil()+attacked.getOil());
                    attacked.setOil(0);
                }
            }else if(moneyPillage<=0 && oilPillage>0){//No tiene suficiente Petroleo pero Oro si
                attacker.setOil(attacker.getOil()+attacked.getOil());
                attacked.setOil(0);
                moneyPillage=0;
                moneyPillage= newMoneyPillage+oilPillage;
                newMoneyPillage=moneyPillage;
                moneyPillage=moneyPillage-attacked.getMoney();
                if(moneyPillage<0){
                    attacker.setMoney(attacker.getMoney()+newMoneyPillage);
                    attacked.setMoney(attacked.getMoney()-newMoneyPillage);
                }else{
                    attacker.setMoney(attacker.getMoney()+attacked.getMoney());
                    attacked.setMoney(0);
                }
            }else{//No tienen suficientes recursos
                attacker.setMoney(attacker.getMoney()+attacked.getMoney());
                attacked.setMoney(0);
                attacker.setOil(attacker.getOil()+attacked.getOil());
                attacked.setOil(0);
            }
        }

        decideRanking.DecideRanking(attacker);
        decideRanking.DecideRanking(attacked);

        List<Warfare> warfares = new ArrayList();
        warfares.add(attacker);
        warfares.add(attacked);

        return warfares;
    }
}
