package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.TipoUnidad;
import com.APIProject.apiProject.exceptions.InvalidAmountException;

import java.util.List;

public class BuyUnit {

    DecideRanking decideRanking;
    public TipoUnidad BuyUnit(TipoUnidad newUnidad){
        List<TipoUnidad> unidades = newUnidad.getUnidadBatalla().getUnidadesBatalla();
        Boolean UnidadExits=false;
        TipoUnidad antUnidad= new TipoUnidad();
        decideRanking = new DecideRanking();

        // Se busca la unidad que se esta actualizando para tomar las unidades ya existentes
        for (TipoUnidad unidad: unidades) {
            if(unidad.getID_Tipo_unidad()==newUnidad.getID_Tipo_unidad()) {
                UnidadExits = true;
                antUnidad = unidad;
                break;
            }
        }

        Double dinero = newUnidad.getUnidadBatalla().getGuerrilla().getDinero();
        Double costoTotalDinero=  newUnidad.getCosto_Dinero()*newUnidad.getTotal_unidades();
        Double petroleo = newUnidad.getUnidadBatalla().getGuerrilla().getPetroleo();
        Double costoTotalPetroleo=  newUnidad.getCosto_petroleo()*newUnidad.getTotal_unidades();

        // Revisa tener el suficiente Oro y Petroleo para comprar las unidades
        if(dinero>=costoTotalDinero && petroleo>=costoTotalPetroleo){
            //Se toman las unidades ya existentes y se le suman a las nuevas
            if(UnidadExits){
                newUnidad.setTotal_unidades(antUnidad.getTotal_unidades()+newUnidad.getTotal_unidades());
            }
            newUnidad.getUnidadBatalla().getGuerrilla().setDinero(dinero-costoTotalDinero);
            newUnidad.getUnidadBatalla().getGuerrilla().setPetroleo(petroleo-costoTotalPetroleo);
            newUnidad.getUnidadBatalla().getGuerrilla().setRecurso_humano(newUnidad.getUnidadBatalla().
                    getGuerrilla().getRecurso_humano()+newUnidad.getTotal_unidades());
            newUnidad.getUnidadBatalla().getGuerrilla().setRecurso_humano(PersonCalculate(newUnidad));
            decideRanking.DecideRanking(newUnidad.getUnidadBatalla().getGuerrilla());
        }else{
            // Se envia un msj de que no se tienen suficientes fondos
            throw  new InvalidAmountException(newUnidad.getID_Tipo_unidad()+"");
        }
        return newUnidad;
    }

    // Calcula los recursos humanos de la Unidad de Batalla
    private Integer PersonCalculate(TipoUnidad newunidad){
        newunidad.getUnidadBatalla().getGuerrilla().setRecurso_humano(0);
        List<TipoUnidad> unidades = newunidad.getUnidadBatalla().getUnidadesBatalla();
        System.out.println(unidades.size());
        for(TipoUnidad unidad: unidades ){
            //Si las unidades son iguales se toma la unidad actualizada para sumar el total de unidades
            if (newunidad.getID_Tipo_unidad()==unidad.getID_Tipo_unidad()) {
                newunidad.getUnidadBatalla().getGuerrilla().setRecurso_humano(newunidad.
                        getUnidadBatalla().getGuerrilla().getRecurso_humano() + newunidad.getTotal_unidades());
            }else {
                newunidad.getUnidadBatalla().getGuerrilla().setRecurso_humano(newunidad.
                        getUnidadBatalla().getGuerrilla().getRecurso_humano() + unidad.getTotal_unidades());
            }
        }
        return newunidad.getUnidadBatalla().getGuerrilla().getRecurso_humano();
    }
}
