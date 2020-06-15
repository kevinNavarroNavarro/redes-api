package com.APIProject.apiProject.dto;

import java.util.List;

public class GuerrillaDTO {

    public static class Request {
        //Declaracion de variables
        private String Email;

        private Integer ID_Guerrilla_Usuario;

        private String Faccion;

        private String Nombre;

        private Integer Recurso_humano;

        private Float Petroleo;

        private Float Dinero;

        private Float Puntaje;

        private Float Indice_defensa;

        private Float Indice_ataque;

        private List<Integer> unidades_batallas;

        public String getEmail() { return Email; }

        public void setEmail(String email) { Email = email; }

        public Integer getID_Guerrilla_Usuario() { return ID_Guerrilla_Usuario; }

        public void setID_Guerrilla_Usuario(Integer ID_Guerrilla_Usuario) { this.ID_Guerrilla_Usuario = ID_Guerrilla_Usuario; }

        public String getDireccion() { return Faccion; }

        public void setDireccion(String direccion) { Faccion = direccion; }

        public String getNombre() { return Nombre; }

        public void setNombre(String nombre) { Nombre = nombre; }

        public Integer getRecurso_humano() { return Recurso_humano; }

        public void setRecurso_humano(Integer recurso_humano) { Recurso_humano = recurso_humano; }

        public Float getPetroleo() { return Petroleo; }

        public void setPetroleo(Float petroleo) { Petroleo = petroleo; }

        public Float getDinero() { return Dinero; }

        public void setDinero(Float dinero) { Dinero = dinero; }

        public Float getPuntaje() { return Puntaje; }

        public void setPuntaje(Float puntaje) { Puntaje = puntaje; }

        public Float getIndice_defensa() { return Indice_defensa; }

        public void setIndice_defensa(Float indice_defensa) { Indice_defensa = indice_defensa; }

        public Float getIndice_ataque() { return Indice_ataque; }

        public void setIndice_ataque(Float indice_ataque) { Indice_ataque = indice_ataque; }

        public List<Integer> getUnidades_batallas() { return unidades_batallas; }

        public void setUnidades_batallas(List<Integer> unidades_batallas) { this.unidades_batallas = unidades_batallas; }

    }

    public static class Response{
        //Declaracion de variables
        private String Email;

        private Integer ID_Guerrilla_Usuario;

        private String Faccion;

        private String Nombre;

        private Integer Recurso_humano;

        private Float Petroleo;

        private Float Dinero;

        private Float Puntaje;

        private Float Indice_defensa;

        private Float Indice_ataque;

        public String getEmail() { return Email; }

        public void setEmail(String email) { Email = email; }

        public void setID_Guerrilla_Usuario(Integer ID_Guerrilla_Usuario) { this.ID_Guerrilla_Usuario = ID_Guerrilla_Usuario; }

        public void setDireccion(String direccion) { Faccion = direccion; }

        public void setNombre(String nombre) { Nombre = nombre; }

        public void setRecurso_humano(Integer recurso_humano) { Recurso_humano = recurso_humano; }

        public void setPetroleo(Float petroleo) { Petroleo = petroleo; }

        public void setDinero(Float dinero) { Dinero = dinero; }

        public void setPuntaje(Float puntaje) { Puntaje = puntaje; }

        public void setIndice_defensa(Float indice_defensa) { Indice_defensa = indice_defensa; }

        public void setIndice_ataque(Float indice_ataque) { Indice_ataque = indice_ataque; }

        public Integer getID_Guerrilla_Usuario() {
            return ID_Guerrilla_Usuario;
        }

        public String getDireccion() {
            return Faccion;
        }

        public String getNombre() {
            return Nombre;
        }

        public Integer getRecurso_humano() {
            return Recurso_humano;
        }

        public Float getPetroleo() {
            return Petroleo;
        }

        public Float getDinero() {
            return Dinero;
        }

        public Float getPuntaje() {
            return Puntaje;
        }

        public Float getIndice_defensa() {
            return Indice_defensa;
        }

        public Float getIndice_ataque() {
            return Indice_ataque;
        }
    }
}
