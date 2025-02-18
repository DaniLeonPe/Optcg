package es.ies.puerto.optcg.project.model.entities;

import java.util.Date;

import jakarta.persistence.*;




@Entity
@Table(name = "expansiones")
public class Expansion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    private String nombre;

    @Column(name = "fecha_lanzamiento")
	private Date fechaLanzamiento;

    public Expansion() {
    }

    public Expansion(int id, String nombre, Date fechaLanzamiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    // Getters y setters
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

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    
}
