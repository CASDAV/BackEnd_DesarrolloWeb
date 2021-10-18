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
    protected String firstName;

    @Column
    protected String lastName;

    @Column
    @Temporal(TemporalType.DATE)
    protected Date birthDate;

    @Column
    @Email
    protected String email;

    @Column
    protected String password;

    @Enumerated(EnumType.STRING)
    protected UserTp userType;

    @OneToMany(mappedBy = "customer")
    protected List<PurchaseOrder> orders;

    public User() {
    }

    public User(String firstName, String lastName, Date birthDate, @Email String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    

    public User(String firstName, String lastName, Date birthDate, @Email String email, String password,
            UserTp userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserTp getUserType() {
        return userType;
    }

    public void setUserType(UserTp userType) {
        this.userType = userType;
    }

    public List<PurchaseOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PurchaseOrder> orders) {
        this.orders = orders;
    }

    

}
