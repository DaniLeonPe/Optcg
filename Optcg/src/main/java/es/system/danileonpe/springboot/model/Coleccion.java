package es.system.danileonpe.springboot.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "colecciones")
public class Coleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColeccion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_carta", nullable = false)
    private Carta carta;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer cantidad;

    public Long getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Long idColeccion) {
        this.idColeccion = idColeccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coleccion that = (Coleccion) o;
        return Objects.equals(idColeccion, that.idColeccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idColeccion);
    }

    @Override
    public String toString() {
        return "Coleccion [idColeccion=" + idColeccion + ", cantidad=" + cantidad + "]";
    }
}