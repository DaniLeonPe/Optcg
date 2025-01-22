package es.system.danileonpe.springboot.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "mazos_cartas")
public class MazoCarta {

    @EmbeddedId
    private MazoCartaId id;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 1")
    private int cantidad;

    public MazoCartaId getId() {
        return id;
    }

    public void setId(MazoCartaId id) {
        this.id = id;
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
        MazoCarta that = (MazoCarta) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MazoCarta [id=" + id + ", cantidad=" + cantidad + "]";
    }
}
