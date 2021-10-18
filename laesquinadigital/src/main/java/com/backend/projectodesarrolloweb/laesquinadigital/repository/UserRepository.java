package com.backend.projectodesarrolloweb.laesquinadigital.repository;

import java.util.List;
import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findById(Long id);

    List<User> findByName(String name);

    Optional<User> findByEmailAndPassword(String email, String password);

    @Query(value = "Select o From User")
    List<PurchaseOrder> findOrders(User user);
}
