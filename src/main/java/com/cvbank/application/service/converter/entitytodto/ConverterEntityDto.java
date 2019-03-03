package com.cvbank.application.service.converter.entitytodto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.cvbank.application.DTO.cv.CvDto;
import com.cvbank.application.DTO.cv.СvResponse;
import com.cvbank.application.entity.Cv;
import com.cvbank.application.entity.User;

public class ConverterEntityDto {
	
	public static СvResponse convCvToCvResponse(User user, Cv cv) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String city = user.getCity();
		String phone = user.getPhone();
		String email = user.getEmail();
		
		List<String> skills = cv.getSkills().stream().map((x) -> x.getSkillName())
							    .collect(Collectors.toList());
		String position = cv.getPosition();
		String summary = cv.getSummary();
		Integer age = LocalDate.now().getYear() - user.getBirthday().getYear();
		
		return СvResponse.builder().firstName(firstName).lastName(lastName)
								   .phone(phone).email(email).position(position)
								   .summary(summary).city(city).age(age)
								   .skills(skills).build();
	}

	public static CvDto convCvToCvDto(Cv cv) {
		// TODO Auto-generated method stub
		return null;
	}


}
