package es.ies.puerto.optcg.project.dto;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;



public record ExpansionDTO(
        @JsonIgnore
        Integer id,
        String nombre,
        LocalDate fechaLanzamiento
) {}
    