package com.cvbank.application.entity;

import lombok.*;

import java.time.Year;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private Integer id;

    @Column(name = "date_from", length = 4, columnDefinition = "year")
    private Year fromYear;

    @Column(name = "date_to", length = 4, columnDefinition = "year")
    private Year toYear;

    @Column(name = "position")
    private String position;

    @Column(name = "company")
    private String company;

    @Column(name = "locale")
    private String locale;

    @Column(name = "info")
    private String info;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv")
    private Cv cv;


}
