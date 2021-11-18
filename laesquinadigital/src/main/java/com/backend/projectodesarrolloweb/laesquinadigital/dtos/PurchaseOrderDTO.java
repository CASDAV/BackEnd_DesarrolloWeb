package com.backend.projectodesarrolloweb.laesquinadigital.dtos;

import java.util.Date;

import com.backend.projectodesarrolloweb.laesquinadigital.model.ShoppingCart;
import com.backend.projectodesarrolloweb.laesquinadigital.model.User;

public class PurchaseOrderDTO {

    protected Long id;

    protected User customer;

    protected Double finalPrice;

    protected ShoppingCart cart;

    protected Date purchaseDate;

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(User customer, Double finalPrice, ShoppingCart cart, Date purchaseDate) {
        this.customer = customer;
        this.finalPrice = finalPrice;
        this.cart = cart;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
