package com.backend.projectodesarrolloweb.laesquinadigital.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;


@Entity
public class UserSys {

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

    @OneToMany(mappedBy = "customer")
    protected List<PurchaseOrder> orders;

    @OneToMany(mappedBy = "user")
    protected List<ShoppingCart> carts;

    public UserSys() {
    }
    public UserSys(String firstName, String lastName, Date birthDate, @Email String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
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


    public List<PurchaseOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PurchaseOrder> orders) {
        this.orders = orders;
    }

    public List<ShoppingCart> getCarts() {
        return carts;
    }

    public void setCarts(List<ShoppingCart> carts) {
        this.carts = carts;
    }
    
}