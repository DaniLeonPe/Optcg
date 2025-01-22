package es.system.danileonpe.springboot.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "expansiones")
public class Expansion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExpansion;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "fecha_lanzamiento", columnDefinition = "DATE")
    private LocalDateTime fechaLanzamiento;

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

    public LocalDateTime getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDateTime fechaLanzamiento) {
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