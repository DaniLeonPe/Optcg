package es.ies.puerto.optcg.project.dto;



import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class ExpansionDTO{
        @JsonIgnore
       private Integer id;
       private String nombre;
       @JsonFormat(pattern = "yyyy-MM-dd")
       private Date fechaLanzamiento;


        public ExpansionDTO() {
        }

    public ExpansionDTO(Integer id, String nombre, Date fechaLanzamiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
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
    