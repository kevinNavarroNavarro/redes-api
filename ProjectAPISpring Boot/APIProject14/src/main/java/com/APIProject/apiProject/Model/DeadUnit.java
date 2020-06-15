package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.GuerrillaUsuario;
import com.APIProject.apiProject.domain.business.TipoUnidad;
import com.APIProject.apiProject.domain.business.UnidadBatalla;

import java.util.List;

public class DeadUnit {

    // Se determinan las muertes de las unidades
    public GuerrillaUsuario DeadUnit(GuerrillaUsuario usuario){

        //Se obtiene la unidad de batalla del usuario
        List<UnidadBatalla> unidadesbatalla = usuario.getUnidad_batallas();
        UnidadBatalla unidadBatalla = unidadesbatalla.get(0);
        List<TipoUnidad> tipoUnidades = unidadBatalla.getUnidadesBatalla();
        usuario.setRecurso_humano(0);

        for (TipoUnidad unidad: tipoUnidades){
            Integer total = unidad.getTotal_unidades();
            Integer result=(int) Math.floor(total/2);
            unidad.setTotal_unidades(result);
            usuario.setRecurso_humano(usuario.getRecurso_humano()+unidad.getTotal_unidades());
        }

        return usuario;
    }
}
