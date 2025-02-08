package es.system.danileonpe.springboot.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "coleccion_cartas")
public class ColeccionCarta {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "id_coleccion", nullable = false)
    private Coleccion coleccion;

    
    @ManyToOne
    @JoinColumn(name = "id_carta", nullable = false)
    private Carta carta;

    @Column(nullable = false)
    private int cantidad;

    // Constructor vacío
    public ColeccionCarta() {}

    // Constructor con parámetros
    public ColeccionCarta(Coleccion coleccion, Carta carta, int cantidad) {
        this.coleccion = coleccion;
        this.carta = carta;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColeccionCarta that = (ColeccionCarta) o;
        return Objects.equals(coleccion, that.coleccion) && Objects.equals(carta, that.carta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coleccion, carta);
    }

    @Override
    public String toString() {
        return "ColeccionCarta [coleccion=" + coleccion + ", carta=" + carta + ", cantidad=" + cantidad + "]";
    }
}
