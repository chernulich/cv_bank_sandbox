package com.cvbank.application.entity;

import com.cvbank.application.entity.type.CvStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cv")

/**
 * 
 * @author Chernulich
 *
 */

public class Cv {

    // TODO: 2019-02-24 Think about relationships

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cv")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user")
    private User user;
    
    @Column(name = "date_creation")
    private LocalDate creationDate;
    
    @Column(name = "position", unique = true, length = 100)
    private String position;
    
    @Column(name = "salary")
    private Integer salary;
    
    @Column(name = "summary")
    private String summary;
    
    @Column(name = "links")
    private String links;   // I have a question   Set<Link>? or simple string?
    
    @Column(name = "count_review")
    private Integer countReview;      
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dir_cv_status")
    @Enumerated(EnumType.STRING)
    private CvStatus cvStatus;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dir_cv_template")
    private CvTemplate cvTemplate;             



}
