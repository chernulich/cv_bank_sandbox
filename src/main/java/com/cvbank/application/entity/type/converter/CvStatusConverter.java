package com.cvbank.application.entity.type.converter;

import javax.persistence.AttributeConverter;

import com.cvbank.application.entity.type.CvStatus;

public class CvStatusConverter implements AttributeConverter<CvStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(CvStatus cvStatus) {
		switch (cvStatus) {
		  case APPROVED:
		   return 0;
		  case NOT_APPROVED:
		   return 1;
		  case NOT_FINISHED:
		   return 2;
		  default:
		   throw new IllegalArgumentException("Unknown value: " + cvStatus);
		  }
	}

	@Override
	public CvStatus convertToEntityAttribute(Integer dbData) {
		switch (dbData) {
		  case 0:
		   return CvStatus.APPROVED;
		  case 1:
		   return CvStatus.NOT_APPROVED;
		  case 2:
		   return CvStatus.NOT_FINISHED;
		  default:
		   throw new IllegalArgumentException("Unknown value: " + dbData);
		  }
	}

}
