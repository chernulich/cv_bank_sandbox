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
@Table(name = "certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certification")
    private Integer id;
    
    @Column(name = "year", length = 4, columnDefinition = "year")
    private Year year;
    
    @Column(name = "id_description")
    private String description;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv")
	private Cv cv;
}
