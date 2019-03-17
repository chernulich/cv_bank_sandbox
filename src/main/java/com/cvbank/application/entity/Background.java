package com.cvbank.application.entity;

import java.time.Year;

import javax.persistence.*;

import com.cvbank.application.entity.type.BackgroundType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "background")

/**
 * 
 * @author Chernulich
 *
 */

public class Background {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_background")
    private Integer id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_background")
    @Enumerated(EnumType.STRING)
    private BackgroundType backgroundType;
	
	@Column(name = "title", length = 200)
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date_start", length = 4)
	private Year dateStart;
	
	@Column(name = "date_end", length = 4)
	private Year dateEnd;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv")
	private Cv cv;
	
	
	
	
	
	
	
	

}
