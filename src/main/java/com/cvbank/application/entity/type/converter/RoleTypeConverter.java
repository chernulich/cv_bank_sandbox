package com.cvbank.application.entity.type.converter;

import javax.persistence.AttributeConverter;

import com.cvbank.application.entity.type.RoleType;

//@Converter(autoApply = true)
public class RoleTypeConverter implements AttributeConverter<RoleType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RoleType roleType) {
        switch (roleType) {
            case JOBSEEKER:
                return 0;
            case HEADHUNTER:
                return 1;
            case SYSTEM:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown value: " + roleType);
        }
    }

    @Override
    public RoleType convertToEntityAttribute(Integer dbData) {
        switch (dbData) {
            case 0:
                return RoleType.JOBSEEKER;
            case 1:
                return RoleType.HEADHUNTER;
            case 2:
                return RoleType.SYSTEM;
            default:
                throw new IllegalArgumentException("Unknown value: " + dbData);
        }
    }

}
