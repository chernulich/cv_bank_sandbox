package com.cvbank.application.service.converter.entitytodto;

import com.cvbank.application.DTO.cv.CvDto;
import com.cvbank.application.DTO.cv.СvResponse;
import com.cvbank.application.entity.Cv;
import com.cvbank.application.entity.User;

public interface ConverterEntityDto {
	
	СvResponse convCvToCvResponse(User user, Cv cv);
	
	CvDto convCvToCvDto(Cv cv);

}
