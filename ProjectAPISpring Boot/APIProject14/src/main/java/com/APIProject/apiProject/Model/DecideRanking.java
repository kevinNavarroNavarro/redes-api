package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.GuerrillaUsuario;

//Calcula el puntaje de cada usuario, (Promedio de Indices) + (Promedio de Recursos)
public class DecideRanking {
    public void DecideRanking(GuerrillaUsuario usuario){
        usuario.setPuntaje(((usuario.getIndice_ataque()+usuario.getIndice_defensa())/2)+
                ((usuario.getDinero()+usuario.getPetroleo())/2));
    }
}
