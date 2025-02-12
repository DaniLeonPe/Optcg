package es.system.danileonpe.springboot.model;


import jakarta.persistence.*;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cartas")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String rareza;

    @Column(nullable = false)
    private int costo;

    private String descripcion;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(
            name = "id_expansion", nullable = false)
    private Expansion expansion;


    private String imagenUrl;

    public Carta() {}

    public Carta(int id){
        this.id = id;
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

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }
    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }


    public Carta(int id, String nombre, String tipo, String rareza, int costo, String descripcion, Expansion expansion, String imagenUrl) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.rareza = rareza;
        this.costo = costo;
        this.descripcion = descripcion;
        this.expansion = expansion;
        this.imagenUrl = imagenUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(id, carta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Carta [idCarta=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
    }
}