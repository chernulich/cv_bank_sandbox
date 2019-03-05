package com.cvbank.application.service.converter.entitytodto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cvbank.application.DTO.cv.AchievementDto;
import com.cvbank.application.DTO.cv.CertificationDto;
import com.cvbank.application.DTO.cv.CvDto;
import com.cvbank.application.DTO.cv.EducationDto;
import com.cvbank.application.DTO.cv.ProjectDto;
import com.cvbank.application.DTO.cv.СvResponse;
import com.cvbank.application.entity.Achievement;
import com.cvbank.application.entity.Certification;
import com.cvbank.application.entity.Cv;
import com.cvbank.application.entity.Education;
import com.cvbank.application.entity.Project;
import com.cvbank.application.entity.User;
/**
 * 
 * @author Chernulich
 *
 */
@Component
public class ConverterEntityDtoImpl implements ConverterEntityDto{
	
	@Override
	public СvResponse convCvToCvResponse(User user, Cv cv) {
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

	@Override
	public CvDto convCvToCvDto(Cv cv) {
		
		List <ProjectDto> projectsDto = cv.getProjects().stream().map((project) -> convProjectToDto(project))
										  .collect(Collectors.toList());
		List <EducationDto> educations = cv.getEducations().stream().map((education) -> convEducationToDto(education))
										  .collect(Collectors.toList());
		List <CertificationDto> certifications = cv.getCertifications().stream().map((certification) -> 
													convCertificationToDto(certification))
												   .collect(Collectors.toList());
		List <AchievementDto> achievements = cv.getAchievements().stream().map((achievement) -> 
											   convAchievementToDto(achievement))
											   .collect(Collectors.toList());
		List <String> languages = cv.getLanguages().stream().map((x) -> x.getName()).collect(Collectors.toList());
		
		List <String> links = cv.getLinks().stream().map((x) -> x.getLink()).collect(Collectors.toList());
		
		return CvDto.builder().projects(projectsDto).educations(educations).certifications(certifications)
							  .achievements(achievements).languages(languages).links(links).build();
	}

	private AchievementDto convAchievementToDto(Achievement achievement) {
		return AchievementDto.builder().description(achievement.getDescription())
							 .nomination(achievement.getNomination())
							 .year(achievement.getYear()).build();
	}

	private CertificationDto convCertificationToDto(Certification certification) {
		return CertificationDto.builder().description(certification.getDescription())
							   .year(certification.getYear()).build();
	}

	private EducationDto convEducationToDto(Education education) {
		return EducationDto.builder().dateFrom(education.getDateFrom()).dateTo(education.getDateTo())
						   .institute(education.getInstitute()).build();
	}

	private ProjectDto convProjectToDto(Project project) {
		return ProjectDto.builder().company(project.getCompany()).fromYear(project.getFromYear())
						 .toYear(project.getToYear()).info(project.getInfo()).locale(project.getLocale())
						 .position(project.getPosition()).build();
	}
	
	
	
	


}
