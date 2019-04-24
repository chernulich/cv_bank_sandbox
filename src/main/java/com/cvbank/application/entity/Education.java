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
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_education")
    private Integer id;

    @Column(name = "date_from", length = 4, columnDefinition = "year")
    private Year dateFrom;

    @Column(name = "date_to", length = 4, columnDefinition = "year")
    private Year dateTo;

    @Column(name = "institute")
    private String institute;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv")
    private Cv cv;

}
