package com.backend.projectodesarrolloweb.laesquinadigital.repository;

import java.util.List;
import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findById(Long id);

    List<User> findByFirstName(String firstName);

    @Query(value = "SELECT u FROM User u WHERE u.email=?1 AND u.password=?2")
    Optional<User> loginMethod(String email, String password);

}
