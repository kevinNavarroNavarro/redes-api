package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.GuerrillaUsuario;

import java.util.List;

public class AttackGuerrilla {

    StolenResources stolenResources;

    public List<GuerrillaUsuario> AttackGuerrilla (GuerrillaUsuario atacante, GuerrillaUsuario atacado){
        stolenResources = new StolenResources();
        if(atacante.getIndice_ataque()>atacado.getIndice_defensa()){
             return stolenResources.StolenResources(atacante,atacado);
        }
        else{

        }
        return null;
    }
}
