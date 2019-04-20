package com.cvbank.application.service.cv;

import java.util.List;

import com.cvbank.application.DTO.cv.BackgroundDto;
import com.cvbank.application.DTO.cv.CvDto;
import com.cvbank.application.DTO.cv.SkillDto;
import com.cvbank.application.DTO.cv.СvResponse;
import com.cvbank.application.entity.Achievement;
import com.cvbank.application.entity.Certification;
import com.cvbank.application.entity.Education;
import com.cvbank.application.entity.Project;

/**
 * 
 * @author Chernulich
 *
 */

public interface CvService {

	Integer createEmptyCv(String token);

	void editSkills(Integer cvId, List<String> skillNames);

	void editLanguages(Integer cvId, List<String> languageNames);

	void deleteCv(Integer cvId);

//	List<СvResponse> getAllCvByUser(String token);
//
//	CvDto getCvById(Integer cvId);

	void editCv(String token, Integer id, CvDto cvDto);

	void editBackground(Integer cvId, BackgroundDto backgroundDto);

	void editAchievement(Integer cvId, Achievement achievement);

	void editCertification(Integer cvId, Certification certification);

	void editEducation(Integer cvId, Education education);

	void editProject(Integer cvId, Project project);
	
	

}
