package com.APIProject.apiProject.domain.business;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tipo")
public class TipoUnidad {

    //Declaracion de Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Tipo_unidad;

    @NotNull
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String Description;

    @NotNull
    @Column(name = "Ataque")
    private Double Ataque;

    @NotNull
    @Column(name = "Defensa")
    private Double Defensa;

    @NotNull
    @Column(name = "Costo_Dinero")
    private Double Costo_Dinero;

    @NotNull
    @Column(name = "Costo_RH")
    private Integer Costo_RH;

    @NotNull
    @Column(name = "Costo_petroleo")
    private Double Costo_petroleo;

    @NotNull
    @Column(name = "Pillaje")
    private Double Pillaje;

    @NotNull
    @Column(name = "Total_unidad")
    private Integer Total_unidades;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_unidad")
    private UnidadBatalla UnidadBatalla;

    //Getters and Setters
    public Integer getID_Tipo_unidad() { return ID_Tipo_unidad; }

    public void setID_Tipo_unidad(Integer ID_Tipo_unidad) { this.ID_Tipo_unidad = ID_Tipo_unidad; }

    public String getDescription() { return Description; }

    public void setDescription(String description) { Description = description; }

    public Double getAtaque() { return Ataque; }

    public void setAtaque(Double ataque) { Ataque = ataque; }

    public Double getDefensa() { return Defensa; }

    public void setDefensa(Double defensa) { Defensa = defensa; }

    public Double getCosto_Dinero() { return Costo_Dinero; }

    public void setCosto_Dinero(Double costo_Dinero) { Costo_Dinero = costo_Dinero; }

    public Integer getCosto_RH() { return Costo_RH; }

    public void setCosto_RH(Integer costo_RH) { Costo_RH = costo_RH; }

    public Double getCosto_petroleo() { return Costo_petroleo; }

    public void setCosto_petroleo(Double costo_petroleo) { Costo_petroleo = costo_petroleo; }

    public Double getPillaje() { return Pillaje; }

    public void setPillaje(Double pillaje) { Pillaje = pillaje; }

    public UnidadBatalla getUnidadBatalla() {
        return UnidadBatalla;
    }

    public void setUnidadBatalla(UnidadBatalla tipo_unidades) {
        this.UnidadBatalla = tipo_unidades;
    }

    public Integer getTotal_unidades() { return Total_unidades; }

    public void setTotal_unidades(Integer total_unidades) { Total_unidades = total_unidades; }

    //toString
    @Override
    public String toString() {
        return "TipoUnidad{" +
                "ID_Tipo_unidad=" + ID_Tipo_unidad +
                ", Description='" + Description + '\'' +
                ", Ataque=" + Ataque +
                ", Defensa=" + Defensa +
                ", Costo_Dinero=" + Costo_Dinero +
                ", Costo_RH=" + Costo_RH +
                ", Costo_petroleo=" + Costo_petroleo +
                ", Pillaje=" + Pillaje +
                '}';
    }
}
