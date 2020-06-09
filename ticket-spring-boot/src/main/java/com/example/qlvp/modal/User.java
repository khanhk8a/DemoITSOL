package com.example.qlvp.modal;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TBL_USER")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBL_USER_SEQ")
    @SequenceGenerator(name = "TBL_USER_SEQ", sequenceName = "TBL_USER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CMND")
    private String cmnd;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    Set<UserRole> userRoles;

}
