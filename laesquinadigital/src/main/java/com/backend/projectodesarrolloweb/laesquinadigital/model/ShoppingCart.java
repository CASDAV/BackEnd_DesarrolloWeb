package com.backend.projectodesarrolloweb.laesquinadigital.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    @OneToOne
    protected UserSys user;

    @OneToMany(fetch = FetchType.EAGER)
    protected List<Product> products;

    public ShoppingCart() {
    }

    public ShoppingCart(UserSys user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public UserSys getUser() {
        return user;
    }

    public void setUser(UserSys user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    

}
