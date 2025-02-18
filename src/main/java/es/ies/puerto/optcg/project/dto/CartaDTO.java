package es.ies.puerto.optcg.project.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class CartaDTO{
    @JsonIgnore
    int id;
    String nombre;
    String tipo;
    String rareza;
    int costo;
    String descripcion;
    int expansion;
    String imagenUrl;

    public CartaDTO() {
    }

    public CartaDTO(int id, String nombre, String tipo, String rareza, int costo, String descripcion, int expansion, String imagenUrl) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.rareza = rareza;
        this.costo = costo;
        this.descripcion = descripcion;
        this.expansion = expansion;
        this.imagenUrl = imagenUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExpansion() {
        return expansion;
    }

    public void setExpansion(int expansion) {
        this.expansion = expansion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
