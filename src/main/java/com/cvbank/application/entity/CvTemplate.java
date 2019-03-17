package com.cvbank.application.entity;

import java.sql.Blob;

import javax.persistence.*;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "dir_cv_template")

/**
 * 
 * @author Chernulich
 *
 */
public class CvTemplate {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dir_cv_template")
    private Integer id;
	
	 @Lob
	 @Column(name = "picture", columnDefinition = "longblob")
	 private byte[] picture;
	 
	 @Lob
	 @Column(name = "template_data", columnDefinition = "longblob")
	 private Blob data;
}
