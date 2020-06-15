package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.GuerrillaUsuario;
import com.APIProject.apiProject.domain.business.TipoUnidad;

public class FactionProperties {

    // Se asignan las caracteristicas de cada Faccion en Guerrilla
    public GuerrillaUsuario PropertiesFractionGuerrilla(GuerrillaUsuario guerrilla) {
        String factionLowerCase = guerrilla.getFaccion().toLowerCase();
        switch(factionLowerCase) {
            case "chino":
                break;
            case "usmc":
                //Son financiados por Wall Street, por lo que reciben 5000 de oro extra al iniciar
                guerrilla.setDinero(guerrilla.getDinero()+5000);
                break;
            case "mec":
                //Tienen acceso facil a petroleo por lo que reciben 3000 extra al iniciar
                guerrilla.setPetroleo(guerrilla.getPetroleo()+3000);
                break;
            default:
                // NO pertenecen a ninguna faccion, por lo que sus aliados le obsequian algunos recursos al inciar
                guerrilla.setDinero(guerrilla.getDinero()+2000);
                guerrilla.setPetroleo(guerrilla.getPetroleo()+1500);
        }
        return guerrilla;
    }

    // Se asignan las caracteristicas de cada Faccion en TipoUnidades
    public TipoUnidad PropertiesFractionTipoUnidad(TipoUnidad tipoUnidad) {
        String factionLowerCase =tipoUnidad.getUnidadBatalla().getGuerrilla().getFaccion().toLowerCase();
        // Si la faccion es chino, entonces sus unidades cuestan 12% menos del valor real de las unidades
        if(factionLowerCase.equals("chino")){
            Double newCostoDinero = tipoUnidad.getCosto_Dinero()-(tipoUnidad.getCosto_Dinero()/10);
            Double newCostoPetroleo = tipoUnidad.getCosto_petroleo()-(tipoUnidad.getCosto_petroleo()/12);
            tipoUnidad.setCosto_Dinero(newCostoDinero);
            tipoUnidad.setCosto_petroleo(newCostoPetroleo);
            System.out.println(newCostoDinero);
            System.out.println(newCostoPetroleo);
        }
        return tipoUnidad;
    }

}
