package es.system.danileonpe.springboot.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "mazos_cartas")
public class MazoCarta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @ManyToOne
    @JoinColumn(name = "id_mazo", nullable = false)
    private Mazo mazo;

    
    @ManyToOne
    @JoinColumn(name = "id_carta", nullable = false)
    private Carta carta;

    @Column(nullable = false)
    private int cantidad;

    // Constructor vacío
    public MazoCarta() {}

    // Constructor con parámetros
    public MazoCarta(Mazo mazo, Carta carta, int cantidad) {
        this.mazo = mazo;
        this.carta = carta;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
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
        MazoCarta mazoCarta = (MazoCarta) o;
        return Objects.equals(mazo, mazoCarta.mazo) && Objects.equals(carta, mazoCarta.carta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mazo, carta);
    }

    @Override
    public String toString() {
        return "MazoCarta [mazo=" + mazo + ", carta=" + carta + ", cantidad=" + cantidad + "]";
    }
}
