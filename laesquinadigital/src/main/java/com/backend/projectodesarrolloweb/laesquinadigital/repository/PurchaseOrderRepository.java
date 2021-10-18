package com.backend.projectodesarrolloweb.laesquinadigital.repository;

import java.util.List;
import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.Product;
import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    
    Optional<PurchaseOrder> findById(Long id);

    List<PurchaseOrder> findByProduct(Product product);

    List<PurchaseOrder> findByCustomer(User customer);



}
