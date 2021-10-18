package com.backend.projectodesarrolloweb.laesquinadigital.dtos;

import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import com.backend.projectodesarrolloweb.laesquinadigital.model.Product;

public class PurchaseOrderDTO {

    protected Long id;

    protected User customer;

    protected Product product;

    protected Integer amount;

    protected Double finalPrice;

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(Long id, User customer, Product product, Integer amount) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public PurchaseOrderDTO(User customer, Product product, Integer amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    
}
