package com.backend.projectodesarrolloweb.laesquinadigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class PurchaseOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne
    protected User customer;

    @Column
    protected Double finalPrice;

    @OneToOne
    protected ShoppingCart cart;

    @Column
    @Temporal(TemporalType.DATE)
    protected Date purchaseDate;


    public PurchaseOrder() {
    }

    public PurchaseOrder(User customer, Double finalPrice, ShoppingCart cart, Date purchaseDate) {
        this.customer = customer;
        this.finalPrice = finalPrice;
        this.cart = cart;
        this.purchaseDate = purchaseDate;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}