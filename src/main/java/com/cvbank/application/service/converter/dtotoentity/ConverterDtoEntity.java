package com.cvbank.application.service.converter.dtotoentity;

import com.cvbank.application.DTO.cv.AchievementDto;
import com.cvbank.application.DTO.cv.CertificationDto;
import com.cvbank.application.DTO.cv.EducationDto;
import com.cvbank.application.DTO.cv.ProjectDto;
import com.cvbank.application.DTO.cv.SkillDto;
import com.cvbank.application.entity.Achievement;
import com.cvbank.application.entity.Certification;
import com.cvbank.application.entity.Education;
import com.cvbank.application.entity.Language;
import com.cvbank.application.entity.Project;
import com.cvbank.application.entity.Skill;
/**
 * 
 * @author Chernulich
 *
 */
public interface ConverterDtoEntity {
	
	Skill convSkillDtoToEntity(SkillDto skillDto);
	
	Project convProjectDtoToEntity(ProjectDto projectDto);
	
	Certification convCertificationDtoToEntity(CertificationDto certificationDto);
	
	Achievement convAchievementDtoToEntity(AchievementDto achievementDto);
	
	Education convEducationDtoToEntity(EducationDto educationDto);
	
	
	
	

}
