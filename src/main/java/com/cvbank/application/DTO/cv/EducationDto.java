package com.cvbank.application.DTO.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationDto {

//    @Positive
//    private Integer id;
//
//    @Positive
//    private Integer idCv;

    private Integer dateFrom;

    private Integer dateTo;

    @NotBlank
    private String institute;

}
