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
@Table(name = "achievement")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_achievement")
    private Integer id;

    @Column(name = "year", length = 4, columnDefinition = "year")
    private Year year;

    @Column(name = "description")
    private String description;

    @Column(name = "nomination")
    private String nomination;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv")
    private Cv cv;

}
