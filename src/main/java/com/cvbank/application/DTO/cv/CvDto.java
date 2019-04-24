package com.cvbank.application.DTO.cv;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvDto {

    private Integer cvId;

    private String position;

    private Integer salary;

    private String summary;

    private String links;
}
