package com.APIProject.apiProject.Model;

import com.APIProject.apiProject.domain.business.TipoUnidad;
import com.APIProject.apiProject.domain.business.UnidadBatalla;
import com.APIProject.apiProject.service.Tipo_UnidadService;
import com.APIProject.apiProject.service.UnidadBatallaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IndiceCalculator {

        @Autowired
        UnidadBatallaService unidadBatallaService= new UnidadBatallaService();

        @Autowired
        Tipo_UnidadService tipoUnidadService= new Tipo_UnidadService();

        //Calcula los indices de ataque y defensa de las guerrillas en partida
        public void SetIndex(TipoUnidad tipoUnidad){

            UnidadBatalla unidadBatalla = tipoUnidad.getUnidadBatalla();
            List<TipoUnidad> tipoUnidades=unidadBatalla.getUnidadesBatalla();
            //Setter el valor a 0 para volver a realizar el calculo
            tipoUnidad.getUnidadBatalla().getGuerrilla().setIndice_ataque(0.0f);
            tipoUnidad.getUnidadBatalla().getGuerrilla().setIndice_defensa(0.0f);

            for(TipoUnidad unidad: tipoUnidades) {//Recorre todas las tropas de la Unidad de Batalla
                if (unidad.getID_Tipo_unidad() == tipoUnidad.getID_Tipo_unidad()) { //Si es actualizacion toma los datos actualizados
                    tipoUnidad.getUnidadBatalla().getGuerrilla().setIndice_ataque(tipoUnidad.getUnidadBatalla().getGuerrilla().getIndice_ataque() +
                            tipoUnidad.getAtaque() * tipoUnidad.getTotal_unidades());
                    tipoUnidad.getUnidadBatalla().getGuerrilla().setIndice_defensa(tipoUnidad.getUnidadBatalla().getGuerrilla().getIndice_defensa() +
                            tipoUnidad.getDefensa() * tipoUnidad.getTotal_unidades());
                }else {
                    unidad.getUnidadBatalla().getGuerrilla().setIndice_ataque(unidad.getUnidadBatalla().getGuerrilla().getIndice_ataque()
                            + unidad.getAtaque() * unidad.getTotal_unidades());
                    unidad.getUnidadBatalla().getGuerrilla().setIndice_defensa(unidad.getUnidadBatalla().getGuerrilla().getIndice_defensa() +
                            unidad.getDefensa() * unidad.getTotal_unidades());
                }
            }
        }

}
