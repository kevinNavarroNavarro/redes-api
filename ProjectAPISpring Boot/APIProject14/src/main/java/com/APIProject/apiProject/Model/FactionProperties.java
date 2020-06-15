package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.GuerrillaUsuario;
import com.APIProject.apiProject.domain.business.TipoUnidad;
import com.APIProject.apiProject.service.GuerrillaService;

import java.util.ArrayList;
import java.util.List;

public class FactionProperties {

    DecideRanking decideRanking ;

    // Se asignan las caracteristicas de cada Faccion en Guerrilla
    public GuerrillaUsuario PropertiesFractionGuerrilla(GuerrillaUsuario guerrilla) {
        String factionLowerCase = guerrilla.getFaccion().toLowerCase();
        switch(factionLowerCase) {
            case "chino":
                break;
            case "usmc":
                //Son financiados por Wall Street, por lo que reciben 1000 de oro extra al iniciar
                guerrilla.setDinero(guerrilla.getDinero()+700);
                break;
            case "mec":
                //Tienen acceso facil a petroleo por lo que reciben 500 extra al iniciar
                guerrilla.setPetroleo(guerrilla.getPetroleo()+200);
                break;
            default:
                // NO pertenecen a ninguna faccion, por lo que sus aliados le obsequian algunos recursos al inciar
                guerrilla.setDinero(guerrilla.getDinero()+300);
                guerrilla.setPetroleo(guerrilla.getPetroleo()+75);
        }
        return guerrilla;
    }

    // Se asignan las caracteristicas de cada Faccion en TipoUnidades
    public TipoUnidad PropertiesFractionTipoUnidad(TipoUnidad tipoUnidad) {
        String factionLowerCase =tipoUnidad.getUnidadBatalla().getGuerrilla().getFaccion().toLowerCase();
        // Si la faccion es chino, entonces sus unidades cuestan 12% menos del valor real de las unidades
        if(factionLowerCase.equals("chino")){
            Double newCostoDinero = tipoUnidad.getCosto_Dinero()-((tipoUnidad.getCosto_Dinero()*10)/100);
            Double newCostoPetroleo = tipoUnidad.getCosto_petroleo()-((tipoUnidad.getCosto_petroleo()*10)/100);
            tipoUnidad.setCosto_Dinero(newCostoDinero);
            tipoUnidad.setCosto_petroleo(newCostoPetroleo);
        }
        return tipoUnidad;
    }

    // Se le asignan recursos a cada guerrilla
    public void UpdateProperties(GuerrillaService service){
        List<GuerrillaUsuario> aux= new ArrayList<>();
        List<GuerrillaUsuario> guerrillas= service.findAll();
        if(!guerrillas.isEmpty() || guerrillas == null) {
            for (GuerrillaUsuario guerrilla : guerrillas) {

                GuerrillaUsuario guerrillaAux = guerrilla;
                switch (guerrilla.getFaccion().toLowerCase()) {
                    case "chino":
                        //guerrillaAux.setRecurso_humano(guerrilla.getRecurso_humano()+250);
                        guerrillaAux.setPetroleo(guerrilla.getPetroleo() + 10);
                        guerrillaAux.setDinero(guerrilla.getDinero() + 250);
                        aux.add(guerrillaAux);
                        break;
                    case "usmc":
                        //guerrillaAux.setRecurso_humano(guerrilla.getRecurso_humano()+400);
                        guerrillaAux.setPetroleo(guerrilla.getPetroleo() + 5);
                        guerrillaAux.setDinero(guerrilla.getDinero() + 150);
                        aux.add(guerrillaAux);
                        break;
                    case "mec":
                        //guerrillaAux.setRecurso_humano(guerrilla.getRecurso_humano()+300);
                        guerrillaAux.setPetroleo(guerrilla.getPetroleo() + 3);
                        guerrillaAux.setDinero(guerrilla.getDinero() + 400);
                        aux.add(guerrillaAux);
                        break;
                    default:
                        //guerrillaAux.setRecurso_humano(guerrilla.getRecurso_humano()+175);
                        guerrillaAux.setPetroleo(guerrilla.getPetroleo() + 2);
                        guerrillaAux.setDinero(guerrilla.getDinero() + 200);
                        aux.add(guerrillaAux);
                        break;
                }
            }
            Update(aux, service);
        }
    }

    // Se actualizan las guerrillas con la suma de los recursos
    private void Update(List<GuerrillaUsuario> guerrillas, GuerrillaService guerrillaService){
        for (GuerrillaUsuario guerrilla: guerrillas){
            guerrillaService.update(guerrilla);
        }
    }

}
