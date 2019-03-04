package com.cvbank.application.service.cv;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvbank.application.DTO.cv.AchievementDto;
import com.cvbank.application.DTO.cv.CertificationDto;
import com.cvbank.application.DTO.cv.CvDto;
import com.cvbank.application.DTO.cv.ProjectDto;
import com.cvbank.application.DTO.cv.SkillDto;
import com.cvbank.application.DTO.cv.СvResponse;
import com.cvbank.application.entity.Achievement;
import com.cvbank.application.entity.Certification;
import com.cvbank.application.entity.Cv;
import com.cvbank.application.entity.Language;
import com.cvbank.application.entity.Project;
import com.cvbank.application.entity.Skill;
import com.cvbank.application.entity.User;
import com.cvbank.application.repository.CvRepository;
import com.cvbank.application.repository.UserRepository;
import com.cvbank.application.repository.UserSessionRepository;
import com.cvbank.application.service.converter.entitytodto.ConverterEntityDto;
import com.cvbank.application.service.converter.dtotoentity.ConverterDtoEntity;
/**
 * 
 * @author Chernulich
 *
 */

@Service

public class CvServiceImpl implements CvService {
	
	@Autowired
	private UserSessionRepository userSession;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CvRepository cvRepository;
	

	@Override
	@Transactional
	public Integer createEmptyCv(String token) {
		User user = userSession.findUserByToken(token);
		Cv cv = Cv.builder().user(user).creationDate(LocalDate.now()).build();
		return cvRepository.save(cv).getId();
	}

	@Override
	@Transactional
	public void editPosition(Integer cvId, String position) {
		Cv cv = cvRepository.findById(cvId).orElse(null);
		cv.setPosition(position);
		cvRepository.save(cv);
	}

	@Override
	@Transactional
	public void editSalary(Integer cvId, Integer salary) {
		Cv cv = cvRepository.findById(cvId).orElse(null);
		cv.setSalary(salary);
		cvRepository.save(cv);	
	}

	@Override
	@Transactional
	public void editSummary(Integer cvId, String summary) {
		Cv cv = cvRepository.findById(cvId).orElse(null);
		cv.setSummary(summary);
		cvRepository.save(cv);			
	}

	@Override
	@Transactional
	public void editSkill(Integer cvId, SkillDto skillDto) {                     
		Cv cv = cvRepository.findById(cvId).orElse(null);
		List<Skill> skills = cv.getSkills();
		if (skills == null) {
			skills = new ArrayList<>();
		}
		Skill skill = ConverterDtoEntity.convSkillDtoToEntity(skillDto);
		skills.add(skill);
		cvRepository.save(cv);		
	}

	@Override
	@Transactional
	public void editProject(Integer cvId, ProjectDto projectDto) {
		Cv cv = cvRepository.findById(cvId).orElse(null);
		Project project = ConverterDtoEntity.convProjectDtoToEntity(projectDto);	
		List<Project> projects = cv.getProjects();   
		if (projects == null) {
			projects = new ArrayList<>();
		}
		projects.add(project);
		cvRepository.save(cv);                       // check the saving of the project Entity in the database
		
	}

	@Override
	@Transactional
	public void editCertification(Integer cvId, CertificationDto certificationDto) {
		Cv cv = cvRepository.findById(cvId).orElse(null);
		Certification certification = ConverterDtoEntity.convCertificationDtoToEntity(certificationDto);
		List<Certification> certifications = cv.getCertifications();
		if (certifications == null) {
			certifications = new ArrayList<>();
		}
		certifications.add(certification);
		cvRepository.save(cv);
		
	}

	@Override
	@Transactional
	public void editAchivement(Integer cvId, AchievementDto achievementDto) {
		Cv cv = cvRepository.findById(cvId).orElse(null);
		Achievement achivement = ConverterDtoEntity.convAchievementDtoToEntity(achievementDto);
		List<Achievement> achievements = cv.getAchievements();
		if (achievements == null) {
			achievements = new ArrayList<>();
		}
		achievements.add(achivement);
		cvRepository.save(cv);
		
	}

	@Override
	@Transactional
	public void editLanguage(Integer cvId, String language) {
		Cv cv = cvRepository.findById(cvId).orElse(null);
		List<Language> languages = cv.getLanguages();
		if(languages == null) {
			languages = new ArrayList<>();
		}
		languages.add(Language.builder().name(language).build());
		cvRepository.save(cv);
	}

	@Override
	@Transactional
	public void deleteCv(Integer cvId) {
		cvRepository.deleteById(cvId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<СvResponse> getAllCvByUser(String token) {
		User user = userSession.findUserByToken(token);
		List<Cv> cvs = user.getCvs();
		List<СvResponse> cvsResponse = cvs.stream()
										  .map((cv) -> ConverterEntityDto.convCvToCvResponse(user, cv))
										  .collect(Collectors.toList());
		return cvsResponse;
	}

	@Override
	@Transactional(readOnly = true)
	public CvDto getCvById(Integer cvId) {
		Cv cv = cvRepository.findById(cvId).orElse(null);
		return ConverterEntityDto.convCvToCvDto(cv);
	}
	
	
	

}
