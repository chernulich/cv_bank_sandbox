package com.cvbank.application.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_companies")
    private Integer id;

    @Column(name = "name_company")
    private String name;

    @Column(name = "link")
    private String link;

    @Column(name = "post_code", length = 10)
    private Integer postcode;

    @Column(name = "phone", length = 20)
    public String phone;

    @Column(name = "country", length = 50)
    public String country;

    @Column(name = "city", length = 50)
    public String city;

    @Column(name = "address")
    public String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_users_companies",
            joinColumns = {@JoinColumn(name = "id_companies")},
            inverseJoinColumns = {@JoinColumn(name = "id_user")})
    public Set<User> users;
}
