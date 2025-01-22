package es.system.danileonpe.springboot.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MazoCartaId implements Serializable {

    @Column(name = "id_mazo")
    private long mazo;

    @Column(name = "id_carta")
    private long carta;

    public long getMazo() {
        return mazo;
    }

    public void setMazo(long mazo) {
        this.mazo = mazo;
    }

    public long getCarta() {
        return carta;
    }

    public void setCarta(long carta) {
        this.carta = carta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazoCartaId that = (MazoCartaId) o;
        return Objects.equals(mazo, that.mazo) && Objects.equals(carta, that.carta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mazo, carta);
    }
}
