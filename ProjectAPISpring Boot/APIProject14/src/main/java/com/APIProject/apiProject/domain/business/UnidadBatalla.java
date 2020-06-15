package com.APIProject.apiProject.domain.business;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="unidad")
public class UnidadBatalla {

    //Declaracion de Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_unidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_guerrilla")
    private GuerrillaUsuario guerrilla;

    @OneToMany(mappedBy = "UnidadBatalla", fetch = FetchType.LAZY)
    private List<TipoUnidad> unidadesBatalla;

    //Getters and Setters
    public Integer getID_unidades() { return ID_unidad; }

    public void setID_unidades(Integer ID_unidades) { this.ID_unidad = ID_unidades; }

    public void setGuerrilla(GuerrillaUsuario guerrilla) {
        this.guerrilla = guerrilla;
    }

    public GuerrillaUsuario getGuerrilla() { return guerrilla; }

    public List<TipoUnidad> getUnidadesBatalla() {
        return unidadesBatalla;
    }

    public void setUnidadesBatalla(List<TipoUnidad> unidadesBatalla) {
        this.unidadesBatalla = unidadesBatalla;
    }

    // toString
    @Override
    public String toString() {
        return "UnidadBatalla{" +
                "ID_unidades=" + ID_unidad +
                ", guerrilla=" + guerrilla +
                '}';
    }
}