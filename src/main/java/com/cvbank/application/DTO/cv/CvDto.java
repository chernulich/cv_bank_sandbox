package com.cvbank.application.DTO.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvDto {

    /*Second chapter*/

    private List <ProjectDto> projects;                 /*Project*/

    private List <EducationDto> educations;             /*Education*/

    private List <CertificationDto> certifications;     /*Certification*/

    private List <AchievementDto> achievements;        /*Achievement*/

    private List <String> languages; //indexing

    private List <String> links;
    
    private Integer salary;
}
