package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.GuerrillaUsuario;

import java.util.ArrayList;
import java.util.List;

public class AttackGuerrilla {
    DeadUnit deadUnit;
    StolenResources stolenResources;

    public List<GuerrillaUsuario> AttackGuerrilla (GuerrillaUsuario atacante, GuerrillaUsuario atacado){
        stolenResources = new StolenResources();
        deadUnit = new DeadUnit();

        if(atacante.getIndice_ataque()>atacado.getIndice_defensa()){// Si gana el atacante
            deadUnit.DeadUnit(atacado);
             return stolenResources.StolenResources(atacante,atacado);
        }
        // Si los poderes del atacante y el atacado son iguales
        else if(atacante.getIndice_ataque()==atacado.getIndice_defensa()) {
            deadUnit.DeadUnit(atacante);
            deadUnit.DeadUnit(atacado);
            List<GuerrillaUsuario> guerrillaUsuarios = new ArrayList<>();
            guerrillaUsuarios.add(atacante);
            guerrillaUsuarios.add(atacado);
            return  guerrillaUsuarios;
        }else { // Si el atacado tiene mas defensa
            deadUnit.DeadUnit(atacante);
            List<GuerrillaUsuario> guerrillaUsuarios = new ArrayList<>();
            guerrillaUsuarios.add(atacante);
            guerrillaUsuarios.add(atacado);
            return  guerrillaUsuarios;
        }

    }
}
