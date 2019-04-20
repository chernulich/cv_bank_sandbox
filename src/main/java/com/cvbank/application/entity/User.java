package com.cvbank.application.entity;

import com.cvbank.application.entity.type.RoleType;
import com.cvbank.application.entity.type.converter.RoleTypeConverter;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    
    @Column(name = "first_name", length = 100)
    private String firstName;
    
    @Column(name = "last_name", length = 100)
    private String lastName;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "birthday")
    private LocalDate birthday;

    @Email
    @Column(name = "email")
    private String email;
    
    @Column(name = "city")
    private String city;
    
    @Convert(converter = RoleTypeConverter.class)
//    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    
    
    


}
