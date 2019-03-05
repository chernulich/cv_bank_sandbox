package com.cvbank.application.service.cv;

import java.util.List;

import com.cvbank.application.DTO.cv.AchievementDto;
import com.cvbank.application.DTO.cv.CertificationDto;
import com.cvbank.application.DTO.cv.CvDto;
import com.cvbank.application.DTO.cv.EducationDto;
import com.cvbank.application.DTO.cv.ProjectDto;
import com.cvbank.application.DTO.cv.SkillDto;
import com.cvbank.application.DTO.cv.СvResponse;

/**
 * 
 * @author Chernulich
 *
 */

public interface CvService {

	Integer createEmptyCv(String token);

	void editPosition(Integer cvId, String position);

	void editSalary(Integer cvId, Integer salary);

	void editSummary(Integer cvId, String summary);

	void editSkill(Integer cvId, SkillDto skill);

	void editProject(Integer cvId, ProjectDto project);

	void editCertification(Integer cvId, CertificationDto certification);

	void editAchivement(Integer cvId, AchievementDto achievement);

	void editLanguage(Integer cvId, String language);

	void deleteCv(Integer cvId);

	List<СvResponse> getAllCvByUser(String token);

	CvDto getCvById(Integer cvId);

	void editEducation(Integer cvId, EducationDto education);

	void editLink(Integer cvId, String link);
	
	

}
