package com.APIProject.apiProject.dto;

import com.APIProject.apiProject.domain.business.TipoUnidad;

import java.util.List;

public class Unidades_BatallaDTO {

    public static class Response{
        //Variables
        private Integer ID_unidades;

        private Integer guerrilla;

        private List<TipoUnidad> unidades;

        //getters and setters
        public Integer getID_unidades() { return ID_unidades; }

        public void setID_unidades(Integer ID_unidades) { this.ID_unidades = ID_unidades; }

        public Integer getGuerrilla() { return guerrilla; }

        public void setGuerrilla(Integer guerrilla) { this.guerrilla = guerrilla; }

        public List<TipoUnidad> getUnidades() { return unidades; }

        public void setUnidades( List<TipoUnidad> unidades) { this.unidades = unidades; }
    }

    public static class Request {
        //Variables
        private Integer ID_unidades;

        private Integer guerrilla;

        private  List<Integer> unidades;

        //getters and setters
        public Integer getID_unidades() { return ID_unidades; }

        public void setID_unidades(Integer ID_unidades) { this.ID_unidades = ID_unidades; }

        public Integer getGuerrilla() { return guerrilla; }

        public void setGuerrilla(Integer guerrilla) { this.guerrilla = guerrilla; }

        public  List<Integer> getTipo_unidades() { return unidades; }

        public void setTipo_unidades( List<Integer> unidades) { this.unidades = unidades; }


    }
}