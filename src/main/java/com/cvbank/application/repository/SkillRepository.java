package com.cvbank.application.repository;

import com.cvbank.application.entity.Skill;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

	List<Skill> findBySkillName(String skillName);
}
