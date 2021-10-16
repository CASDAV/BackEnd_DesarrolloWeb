package com.backend.projectodesarrolloweb.laesquinadigital.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected String name;

    @Column
    @Temporal(TemporalType.DATE)
    protected Date birthDate;

    @Column
    protected String email;

    @Column
    @Email
    protected String password;

    @Enumerated(EnumType.STRING)
    protected UserTp userType;

    @OneToMany(mappedBy = "customer")
    protected List<PurchaseOrder> orders;

    public User() {
    }

    public User(String name, Date birthDate, String email, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.userType = UserTp.CUSTOMER; 
    }

    public User(String name, Date birthDate, String email, @Email String password, UserTp userType) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    

}
