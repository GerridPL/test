package pl.test.test;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class HumanConverter implements AttributeConverter<HumanType, String> {

    @Override
    public String convertToDatabaseColumn(HumanType humanType) {
        return humanType.getName();
    }

    @Override
    public HumanType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new HumanType(dbData);
    }
}
