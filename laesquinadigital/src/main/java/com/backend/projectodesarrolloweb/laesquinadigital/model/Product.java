package com.backend.projectodesarrolloweb.laesquinadigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected String name;

    @Column
    protected String description;

    @Column
    protected Double price;

    @Column
    protected String image;

    @OneToOne(mappedBy = "product")
    protected PurchaseOrder order;

}
 