package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.TipoUnidad;
import com.APIProject.apiProject.exceptions.InvalidAmountException;

import java.util.List;

public class BuyUnit {

    public TipoUnidad BuyUnit(TipoUnidad newUnidad){

        List<TipoUnidad> unidades = newUnidad.getUnidadBatalla().getUnidadesBatalla();
        Boolean UnidadExits=false;
        TipoUnidad antUnidad= new TipoUnidad();

        // Se busca la unidad que se esta actualizando para tomar las unidades ya existentes
        for (TipoUnidad unidad: unidades) {
            if(unidad.getID_Tipo_unidad()==newUnidad.getID_Tipo_unidad()) {
                UnidadExits = true;
                antUnidad = unidad;
                break;
            }
        }

        Float dinero = newUnidad.getUnidadBatalla().getGuerrilla().getDinero();
        Float costoTotalDinero=  newUnidad.getCosto_Dinero()*newUnidad.getTotal_unidades();
        Float petroleo = newUnidad.getUnidadBatalla().getGuerrilla().getPetroleo();
        Float costoTotalPetroleo=  newUnidad.getCosto_petroleo()*newUnidad.getTotal_unidades();

        // Revisa tener el suficiente Oro y Petroleo para comprar las unidades
        if(dinero>=costoTotalDinero && petroleo>=costoTotalPetroleo){
            //Se toman las unidades ya existentes y se le suman a las nuevas
            if(UnidadExits){
                newUnidad.setTotal_unidades(antUnidad.getTotal_unidades()+newUnidad.getTotal_unidades());
            }
            newUnidad.getUnidadBatalla().getGuerrilla().setDinero(dinero-costoTotalDinero);
            newUnidad.getUnidadBatalla().getGuerrilla().setPetroleo(petroleo-costoTotalPetroleo);
        }else{
            // Se envia un msj de que no se tienen suficientes fondos
            throw  new InvalidAmountException(newUnidad.getID_Tipo_unidad()+"");
        }
        return newUnidad;
    }
}
