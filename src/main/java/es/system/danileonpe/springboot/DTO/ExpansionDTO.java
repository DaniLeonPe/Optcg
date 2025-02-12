package es.system.danileonpe.springboot.DTO;

import java.time.LocalDate;

public class ExpansionDTO {
    private int id;
    private String nombre;
    private LocalDate fechaLanzamiento;

    // Constructores
    public ExpansionDTO() {}

    public ExpansionDTO(int id, String nombre, LocalDate fechaLanzamiento) {
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

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
