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
public class CertificationDto {

//    @Positive
//    private Integer id;
//
//    @Positive
//    private Integer idCv;

    private Integer year;

    @NotBlank
    private String description;
}
