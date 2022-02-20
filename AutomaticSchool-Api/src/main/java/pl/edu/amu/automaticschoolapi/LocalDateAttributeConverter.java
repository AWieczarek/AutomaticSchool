package pl.edu.amu.automaticschoolapi;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.joda.time.LocalDate;
import java.sql.Date;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return locDate == null ? null : Date.valueOf(String.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        if(date == null) return null;
        return new LocalDate(date);
    }


}