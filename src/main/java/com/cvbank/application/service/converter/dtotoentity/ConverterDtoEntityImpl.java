package com.cvbank.application.service.converter.dtotoentity;

import org.springframework.stereotype.Component;

import com.cvbank.application.DTO.cv.AchievementDto;
import com.cvbank.application.DTO.cv.CertificationDto;
import com.cvbank.application.DTO.cv.EducationDto;
import com.cvbank.application.DTO.cv.ProjectDto;
import com.cvbank.application.DTO.cv.SkillDto;
import com.cvbank.application.entity.Achievement;
import com.cvbank.application.entity.Certification;
import com.cvbank.application.entity.Education;
import com.cvbank.application.entity.Project;
import com.cvbank.application.entity.Skill;

/**
 * 
 * @author Chernulich
 *
 */

@Component
public class ConverterDtoEntityImpl implements ConverterDtoEntity{
	
	@Override
	public  Skill convSkillDtoToEntity(SkillDto skillDto) {
		return Skill.builder().skillName(skillDto.getSkillName()).build();
	}
	
	@Override
	public Project convProjectDtoToEntity(ProjectDto projectDto) {
		return Project.builder().company(projectDto.getCompany())
				.fromYear(projectDto.getFromYear())
				.toYear(projectDto.getToYear())
				.info(projectDto.getInfo()).locale(projectDto.getLocale())
				.position(projectDto.getPosition()).build();	
	}
	
	@Override
	public Certification convCertificationDtoToEntity(CertificationDto certificationDto) {
		return Certification.builder().description(certificationDto.getDescription())
				  .year(certificationDto.getYear()).build();
	}
	
	@Override
	public Achievement convAchievementDtoToEntity(AchievementDto achievementDto) {
		return Achievement.builder().description(achievementDto.getDescription())
						  .year(achievementDto.getYear())
						  .nomination(achievementDto.getNomination()).build();
	}

	@Override
	public Education convEducationDtoToEntity(EducationDto educationDto) {
		return Education.builder().dateFrom(educationDto.getDateFrom()).dateTo(educationDto.getDateTo())
				.institute(educationDto.getInstitute()).build();
	}

	
}
