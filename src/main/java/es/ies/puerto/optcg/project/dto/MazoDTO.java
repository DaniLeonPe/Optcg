package es.ies.puerto.optcg.project.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class MazoDTO{
    int id;
    int idUsuario;
    String nombre;
    String descripcion;
    Date fechaCreacion;


    public MazoDTO() {
    }

    public MazoDTO(int id, int idUsuario, String nombre, String descripcion, Date fechaCreacion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
