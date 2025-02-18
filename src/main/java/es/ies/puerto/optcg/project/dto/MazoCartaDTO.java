package es.ies.puerto.optcg.project.dto;

public class MazoCartaDTO{
    int id;
    int idMazo;
    int idCarta;
    int cantidad;


    public MazoCartaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMazo() {
        return idMazo;
    }

    public void setIdMazo(int idMazo) {
        this.idMazo = idMazo;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
