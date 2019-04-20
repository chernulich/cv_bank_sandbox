package com.cvbank.application.service.converter.dtotoentity;

import com.cvbank.application.DTO.cv.SkillDto;
import com.cvbank.application.entity.Skill;
/**
 * 
 * @author Chernulich
 *
 */
public interface ConverterDtoEntity {
	
	Skill convSkillDtoToEntity(SkillDto skillDto);
	

	
	

}
