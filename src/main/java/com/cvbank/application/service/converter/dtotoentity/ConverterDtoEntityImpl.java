package com.cvbank.application.service.converter.dtotoentity;

//import org.springframework.stereotype.Component;

import com.cvbank.application.DTO.cv.SkillDto;
import com.cvbank.application.entity.Skill;

/**
 * @author Chernulich
 */

//@Component
public class ConverterDtoEntityImpl implements ConverterDtoEntity {

    @Override
    public Skill convSkillDtoToEntity(SkillDto skillDto) {
        return Skill.builder().skillName(skillDto.getSkillName()).build();
    }


}
