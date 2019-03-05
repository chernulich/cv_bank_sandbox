package com.cvbank.application.DTO.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AchievementDto {

    private Integer year;

//    @Positive
//    private Integer idCv;
//
//    @Positive
//    private Integer id;

    @NotBlank
    private String description;

    @NotBlank
    private String nomination;
}
