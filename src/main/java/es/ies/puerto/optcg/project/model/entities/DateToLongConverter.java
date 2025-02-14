package es.ies.puerto.optcg.project.model.entities;

import java.util.Date;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DateToLongConverter implements AttributeConverter<Date, Long>{
    
    @Override
    public Long convertToDatabaseColumn(Date date){
        return (date == null) ? null : date.getTime();

    }

    @Override
    public Date convertToEntityAttribute(Long timestamp){
        return (timestamp == null) ? null : new Date(timestamp);
    }
}
