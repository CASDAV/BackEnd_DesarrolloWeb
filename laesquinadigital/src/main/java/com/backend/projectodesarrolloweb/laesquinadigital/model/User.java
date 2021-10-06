package com.backend.projectodesarrolloweb.laesquinadigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column
    protected String name;

    @Column
    @Temporal(TemporalType.DATE)
    protected Date birthDate;

    @Column
    protected String email;

    @Column
    protected String password;

    // protected List<PurchaseOrder> orders;

    public User() {
    }

}
