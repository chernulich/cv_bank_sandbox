package com.cvbank.application.controller;

import com.cvbank.application.DTO.cv.*;
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

    @PostMapping("/edit/create_cv")
    public Integer createEmptyCv(@RequestHeader("Authorization") String token) {
        return cvService.createEmptyCv(token);
    }

    @PostMapping("/edit/position")
    public void editPosition(@RequestHeader("Authorization") String token,
    						 @RequestParam("cvId") Integer cvId,
                             @RequestParam("position") String position) {
    	cvService.editPosition(cvId, position);

    }

    @PostMapping("/edit/salary")
    public void editSalary(@RequestHeader("Authorization") String token,
    					   @RequestParam(name = "cvId") Integer cvId,
                           @RequestParam(name = "salary") Integer salary) {
    	cvService.editSalary(cvId, salary);

    }

    @PostMapping("/edit/summary")
    public void editSummary(@RequestHeader("Authorization") String token,
    						@RequestParam(name = "cvId") Integer cvId,
                            @RequestParam("summary") String summary) {
    	cvService.editSummary(cvId, summary);

    }

    @PostMapping("/edit/skill")
    public void editSkill(@RequestHeader("Authorization") String token,
    					  @RequestParam(name = "cvId") Integer cvId,
                          @RequestBody SkillDto skill) {               //  or @RequestParam String skillName?
    	cvService.editSkill(cvId, skill);

    }

    @PostMapping("/edit/project")
    public void editProject(@RequestHeader("Authorization") String token,
    						@RequestParam(name = "cvId") Integer cvId,
                            @RequestBody ProjectDto project) {
    	cvService.editProject(cvId, project);

    }

    @PostMapping("/edit/certification")
    public void editCertification(@RequestHeader("Authorization") String token,
    							  @RequestParam(name = "cvId") Integer cvId,
                                  @RequestBody CertificationDto certification) {
    	cvService.editCertification(cvId, certification);

    }

    @PostMapping("/edit/achievement")
    public void editAchivement(@RequestHeader("Authorization") String token,
    						   @RequestParam(name = "cvId") Integer cvId,
                               @RequestBody AchievementDto achievement) {
    	cvService.editAchivement(cvId, achievement);

    }

    @PostMapping("/edit/language")
    public void editLanguage(@RequestHeader("Authorization") String token,
    						 @RequestParam(name = "cvId") Integer cvId,
                             @RequestParam String language) {
    	cvService.editLanguage(cvId, language);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteCv(@RequestHeader("Authorization") String token,
                         @PathVariable(name = "id") Integer cvId) {
    	cvService.deleteCv(cvId);	
    }

    @GetMapping("/get_all")
    public List <СvResponse> getAllCvByUser(@RequestHeader("Authorization") String token) {
        return cvService.getAllCvByUser(token);
    }
    
    @GetMapping("/get_cv")
    public CvDto getCvById(@RequestHeader("Authorization") String token,
    					   @RequestParam(name = "cvId") Integer cvId) {
        return cvService.getCvById(cvId);
    }

}
