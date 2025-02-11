package es.system.danileonpe.springboot.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "expansiones")
public class Expansion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExpansion;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "fechaLanzamiento", columnDefinition = "DATE")
    private Date fechaLanzamiento;

    public int getIdExpansion() {
        return idExpansion;
    }

    public void setIdExpansion(int idExpansion) {
        this.idExpansion = idExpansion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expansion that = (Expansion) o;
        return Objects.equals(idExpansion, that.idExpansion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExpansion);
    }

    @Override
    public String toString() {
        return "Expansion [idExpansion=" + idExpansion + ", nombre=" + nombre + "]";
    }
}