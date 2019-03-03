package com.cvbank.application.service.converter.dtotoentity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.cvbank.application.DTO.cv.AchievementDto;
import com.cvbank.application.DTO.cv.CertificationDto;
import com.cvbank.application.DTO.cv.ProjectDto;
import com.cvbank.application.DTO.cv.SkillDto;
import com.cvbank.application.DTO.cv.СvResponse;
import com.cvbank.application.entity.Achievement;
import com.cvbank.application.entity.Certification;
import com.cvbank.application.entity.Cv;
import com.cvbank.application.entity.Project;
import com.cvbank.application.entity.Skill;
import com.cvbank.application.entity.User;
import com.cvbank.application.repository.CvRepository;

/**
 * 
 * @author Chernulich
 *
 */



public class ConverterDtoEntity {
	
	public static  Skill convSkillDtoToEntity(SkillDto skillDto) {
		return Skill.builder().skillName(skillDto.getSkillName()).build();
	}
	
	public static Project convProjectDtoToEntity(ProjectDto projectDto) {
		return Project.builder().company(projectDto.getCompany())
				.fromYear(projectDto.getFromYear())
				.toYear(projectDto.getToYear())
				.info(projectDto.getInfo()).locale(projectDto.getLocale())
				.position(projectDto.getPosition()).build();	
	}
	
	public static Certification convCertificationDtoToEntity(CertificationDto certificationDto) {
		return Certification.builder().description(certificationDto.getDescription())
				  .year(certificationDto.getYear()).build();
	}

	public static Achievement convAchievementDtoToEntity(AchievementDto achievementDto) {
		return Achievement.builder().description(achievementDto.getDescription())
						  .year(achievementDto.getYear())
						  .nomination(achievementDto.getNomination()).build();
	}

	
}
