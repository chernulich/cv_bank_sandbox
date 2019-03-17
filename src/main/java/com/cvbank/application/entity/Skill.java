package com.cvbank.application.entity;

import lombok.*;

import java.util.Set;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "dir_skills")

/**
 * 
 * @author Chernulich
 *
 */
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skills")
    private Integer id;
    
    @Column(name = "name_skill", unique = true, length = 100)
    private String skillName;
    
    @Column(name = "count_of_use")
    private Integer count;           // What it is?
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_cv_dir_skills", 
               joinColumns = {@JoinColumn(name = "id_skills")}, 
               inverseJoinColumns = {@JoinColumn(name = "id_cv")})
    private Set<Cv> cvs;
    
    

}
