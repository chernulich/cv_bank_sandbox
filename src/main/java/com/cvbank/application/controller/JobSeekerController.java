package com.cvbank.application.controller;

import com.cvbank.application.DTO.cv.*;
import com.cvbank.application.entity.Achievement;
import com.cvbank.application.entity.Certification;
import com.cvbank.application.entity.Education;
import com.cvbank.application.entity.Project;
import com.cvbank.application.service.cv.CvService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 
 * @author Chernulich
 *
 */
@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {
	
	@Autowired
	private CvService cvService;

    @PostMapping("/create/cv")
    public Integer createEmptyCv(@RequestHeader("Authorization") String token) {
        return cvService.createEmptyCv(token);
    }
    
    @PostMapping("/edit/cv")
    public void editCv(@RequestHeader("Authorization") String token,
			 			@RequestParam(name = "id") Integer id,
			 			@RequestBody CvDto cvDto) {
    	cvService.editCv(token, id, cvDto);
    }

    @PostMapping("/edit/skills")
    public void editSkills(@RequestHeader("Authorization") String token,
    					  @RequestParam(name = "cvId") Integer cvId,
                          @RequestBody List<String> skillNames) {               //  or @RequestParam String skillName?
    	cvService.editSkills(cvId, skillNames);

    }

    @PostMapping("/edit/languages")
    public void editLanguage(@RequestHeader("Authorization") String token,
    						 @RequestParam(name = "cvId") Integer cvId,
                             @RequestParam List<String> languageNames) {
    	cvService.editLanguages(cvId, languageNames);
    }
    
    @PostMapping("/edit/Background")
    public void editBackground(@RequestHeader("Authorization") String token,
    						 @RequestParam(name = "cvId") Integer cvId,
    						 @RequestBody BackgroundDto backgroundDto) {
    	cvService.editBackground(cvId, backgroundDto);
    }
    
    @PostMapping("/edit/achievement")
    public void editAchievement(@RequestHeader("Authorization") String token,
    						 @RequestParam(name = "cvId") Integer cvId,
    						 @RequestBody Achievement achievement) {
    	cvService.editAchievement(cvId, achievement);
    }
    
    @PostMapping("/edit/certification")
    public void editCertification(@RequestHeader("Authorization") String token,
    						 @RequestParam(name = "cvId") Integer cvId,
    						 @RequestBody Certification certification) {
    	cvService.editCertification(cvId, certification);
    }
    
    @PostMapping("/edit/education")
    public void editEducation(@RequestHeader("Authorization") String token,
    						 @RequestParam(name = "cvId") Integer cvId,
    						 @RequestBody Education education) {
    	cvService.editEducation(cvId, education);
    }
    
    @PostMapping("/edit/project")
    public void editProject(@RequestHeader("Authorization") String token,
    						 @RequestParam(name = "cvId") Integer cvId,
    						 @RequestBody Project project) {
    	cvService.editProject(cvId, project);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCv(@RequestHeader("Authorization") String token,
                         @PathVariable(name = "id") Integer cvId) {
    	cvService.deleteCv(cvId);	
    }

//    @GetMapping("/get_all")
//    public List <СvResponse> getAllCvByUser(@RequestHeader("Authorization") String token) {
//        return cvService.getAllCvByUser(token);
//    }
//    
//    @GetMapping("/get_cv")
//    public CvDto getCvById(@RequestHeader("Authorization") String token,
//    					   @RequestParam(name = "cvId") Integer cvId) {
//        return cvService.getCvById(cvId);
//    }

}
