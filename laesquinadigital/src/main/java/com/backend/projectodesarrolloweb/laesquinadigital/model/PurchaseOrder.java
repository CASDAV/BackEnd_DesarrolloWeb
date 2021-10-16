package com.backend.projectodesarrolloweb.laesquinadigital.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PurchaseOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    protected User customer;

    @ManyToOne
    protected Product product;

    @Column
    protected Integer amount;

}