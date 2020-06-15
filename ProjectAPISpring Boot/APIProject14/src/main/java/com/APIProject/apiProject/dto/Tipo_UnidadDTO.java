package com.APIProject.apiProject.dto;

public class Tipo_UnidadDTO {

    public static class Response {
        //Variables
        private Integer ID_Tipo_unidad;

        private String Description;

        private Float Ataque;

        private Float Defensa;

        private Float Costo_Dinero;

        private Integer Costo_RH;

        private Float Costo_petroleo;

        private Float Pillaje;

        private Integer unidad_batalla;

        private Integer Total_unidades;

        //getters and setters
        public void setID_Tipo_unidad(Integer ID_Tipo_unidad) { this.ID_Tipo_unidad = ID_Tipo_unidad; }

        public void setDescription(String description) { Description = description; }

        public void setAtaque(Float ataque) { Ataque = ataque; }

        public void setDefensa(Float defensa) { Defensa = defensa; }

        public void setCosto_Dinero(Float costo_Dinero) { Costo_Dinero = costo_Dinero; }

        public void setCosto_RH(Integer costo_RH) { Costo_RH = costo_RH; }

        public void setCosto_petroleo(Float costo_petroleo) { Costo_petroleo = costo_petroleo; }

        public void setPillaje(Float pillaje) { Pillaje = pillaje; }

        public void setUnidad_batalla(Integer unidad_batalla) { this.unidad_batalla = unidad_batalla; }

        public void setTotal_unidades(Integer total_unidades) { Total_unidades = total_unidades; }

        public Integer getID_Tipo_unidad() {
            return ID_Tipo_unidad;
        }

        public String getDescription() {
            return Description;
        }

        public Float getAtaque() {
            return Ataque;
        }

        public Float getDefensa() {
            return Defensa;
        }

        public Float getCosto_Dinero() {
            return Costo_Dinero;
        }

        public Integer getCosto_RH() {
            return Costo_RH;
        }

        public Float getCosto_petroleo() {
            return Costo_petroleo;
        }

        public Float getPillaje() {
            return Pillaje;
        }

        public Integer getUnidad_batalla() {
            return unidad_batalla;
        }

        public Integer getTotal_unidades() {
            return Total_unidades;
        }
    }

    public static class Request {

        //Variables
        private Integer ID_Tipo_unidad;

        private String Description;

        private Float Ataque;

        private Float Defensa;

        private Float Costo_Dinero;

        private Float Pillaje;

        private Integer Costo_RH;

        private Float Costo_petroleo;

        private Integer unidadBatalla;

        private Integer Total_unidades;

        //getters and setters
        public Integer getID_Tipo_unidad() { return ID_Tipo_unidad; }

        public String getDescription() { return Description; }

        public Float getAtaque() { return Ataque; }

        public Float getDefensa() { return Defensa; }

        public Float getCosto_Dinero() { return Costo_Dinero; }

        public Integer getCosto_RH() { return Costo_RH; }

        public Float getCosto_petroleo() { return Costo_petroleo; }

        public Integer getUnidadesBatalla() { return unidadBatalla; }

        public Float getPillaje() { return Pillaje; }

        public Integer getTotal_unidades() { return Total_unidades; }

        public void setID_Tipo_unidad(Integer ID_Tipo_unidad) {
            this.ID_Tipo_unidad = ID_Tipo_unidad;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public void setAtaque(Float ataque) {
            Ataque = ataque;
        }

        public void setDefensa(Float defensa) {
            Defensa = defensa;
        }

        public void setCosto_Dinero(Float costo_Dinero) {
            Costo_Dinero = costo_Dinero;
        }

        public void setPillaje(Float pillaje) {
            Pillaje = pillaje;
        }

        public void setCosto_RH(Integer costo_RH) {
            Costo_RH = costo_RH;
        }

        public void setCosto_petroleo(Float costo_petroleo) {
            Costo_petroleo = costo_petroleo;
        }

        public void setUnidadBatalla(Integer unidadBatalla) {
            this.unidadBatalla = unidadBatalla;
        }

        public void setTotal_unidades(Integer total_unidades) {
            Total_unidades = total_unidades;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "ID_Tipo_unidad=" + ID_Tipo_unidad +
                    ", Description='" + Description + '\'' +
                    ", Ataque=" + Ataque +
                    ", Defensa=" + Defensa +
                    ", Costo_Dinero=" + Costo_Dinero +
                    ", Pillaje=" + Pillaje +
                    ", Costo_RH=" + Costo_RH +
                    ", Costo_petroleo=" + Costo_petroleo +
                    ", unidadBatalla=" + unidadBatalla +
                    ", Total_unidades=" + Total_unidades +
                    '}';
        }
    }
}
