package com.cvbank.application.service.cv;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvbank.application.DTO.cv.BackgroundDto;
import com.cvbank.application.DTO.cv.CvDto;
import com.cvbank.application.entity.Achievement;
import com.cvbank.application.entity.Certification;
import com.cvbank.application.entity.Cv;
import com.cvbank.application.entity.Education;
import com.cvbank.application.entity.Language;
import com.cvbank.application.entity.Project;
import com.cvbank.application.entity.Skill;
import com.cvbank.application.entity.User;
import com.cvbank.application.repository.AchievementRepository;
import com.cvbank.application.repository.CertificationRepository;
import com.cvbank.application.repository.CvRepository;
import com.cvbank.application.repository.EducationRepository;
import com.cvbank.application.repository.LanguageRepository;
import com.cvbank.application.repository.ProjectRepository;
import com.cvbank.application.repository.SkillRepository;
import com.cvbank.application.repository.UserSessionRepository;

/**
 * @author Chernulich
 */

@Service

public class CvServiceImpl implements CvService {

    @Autowired
    private UserSessionRepository userSession;

    @Autowired
    private CvRepository cvRepository;

    @Autowired
    private LanguageRepository languageRepository;

//	@Autowired
//	private ConverterEntityDto converterEntityDto;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private CertificationRepository certificationRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    @Transactional
    public Integer createEmptyCv(String token) {
        User user = userSession.findUserByToken(token);
        Cv cv = Cv.builder().user(user).creationDate(LocalDate.now()).build();
        return cvRepository.save(cv).getId();
    }

    @Override        //TODO
    @Transactional
    public void editSkills(Integer cvId, List<String> skillNames) {
        Cv cv = cvRepository.findById(cvId).get();
        for (int i = 0; i < skillNames.size(); i++) {
            List<Skill> skills = skillRepository.findBySkillName(skillNames.get(i));
            if (skills == null) {
                Set<Cv> cvs = new HashSet<>();
                cvs.add(cv);
                Skill skill = Skill.builder().skillName(skillNames.get(i)).cvs(cvs).build();
                skillRepository.save(skill);
            } else {
                skills.get(0).getCvs().add(cv);
            }
        }

    }

    @Override         //TODO
    @Transactional
    public void editLanguages(Integer cvId, List<String> languageNames) {
        Cv cv = cvRepository.findById(cvId).orElse(null);
        for (int i = 0; i < languageNames.size(); i++) {
            List<Language> languages = languageRepository.findByLanguageName(languageNames.get(i));
            if (languages == null) {
                Set<Cv> cvs = new HashSet<>();
                cvs.add(cv);
                Language language = Language.builder().languageName(languageNames.get(i)).cvs(cvs).build();
                languageRepository.save(language);
            } else {
                languages.get(0).getCvs().add(cv);
            }
        }
    }

    @Override      //TODO
    @Transactional
    public void editCv(String token, Integer id, CvDto cvDto) {
        // TODO Auto-generated method stub
        Cv cv = cvRepository.findById(id).orElse(null);
        if (cv == null) {
            User user = userSession.findUserByToken(token);
            cv = Cv.builder().user(user).build();
        }
        cv.setCreationDate(LocalDate.now());
        cv.setLinks(cvDto.getLinks());
        cv.setPosition(cvDto.getPosition());
        cv.setSalary(cvDto.getSalary());
        cv.setSummary(cvDto.getSummary());
        cvRepository.save(cv);
    }

    @Override
    @Transactional
    public void editAchievement(Integer cvId, Achievement achievement) {
        if (achievement.getId() == null) {
            Cv cv = cvRepository.findById(cvId).get();
            achievement.setCv(cv);
        }
        achievementRepository.save(achievement);
    }

    @Override
    @Transactional
    public void editCertification(Integer cvId, Certification certification) {
        if (certification.getId() == null) {
            Cv cv = cvRepository.findById(cvId).get();
            certification.setCv(cv);
        }
        certificationRepository.save(certification);
    }

    @Override
    @Transactional
    public void editEducation(Integer cvId, Education education) {
        if (education.getId() == null) {
            Cv cv = cvRepository.findById(cvId).get();
            education.setCv(cv);
        }
        educationRepository.save(education);
    }

    @Override
    @Transactional
    public void editProject(Integer cvId, Project project) {
        if (project.getId() == null) {
            Cv cv = cvRepository.findById(cvId).get();
            project.setCv(cv);
        }
        projectRepository.save(project);
    }


}
