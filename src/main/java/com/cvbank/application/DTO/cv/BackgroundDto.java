package com.cvbank.application.DTO.cv;

import java.time.Year;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BackgroundDto {

    private Integer idCv;

    private String background;

    private String title;

    private String description;

    private Year dateStart;

    private Year dateEnd;

}
