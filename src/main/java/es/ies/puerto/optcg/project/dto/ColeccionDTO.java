package es.ies.puerto.optcg.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ColeccionDTO{
    @JsonIgnore
   private int id;
    private int usuario;
    private int carta;
    private int cantidad;


    public ColeccionDTO() {
    }

    public ColeccionDTO(int id, int usuario, int carta, int cantidad) {
        this.id = id;
        this.usuario = usuario;
        this.carta = carta;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getCarta() {
        return carta;
    }

    public void setCarta(int carta) {
        this.carta = carta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
