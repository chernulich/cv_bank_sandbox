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
@Table(name = "dir_languages")

/**
 *
 * @author Chernulich
 *
 */
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_language")
    private Integer id;

    @Column(name = "name_language", unique = true, length = 100)
    private String languageName;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_cv_dir_languages",
            joinColumns = {@JoinColumn(name = "id_language")},
            inverseJoinColumns = {@JoinColumn(name = "id_cv")})
    private Set<Cv> cvs;
}
