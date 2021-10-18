package com.backend.projectodesarrolloweb.laesquinadigital.service;


import com.backend.projectodesarrolloweb.laesquinadigital.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuariosService {
    
    void deleteUser(Long id);

    User updateUser(User user, Long id);

    User getUserById(Long  id);

    User createUser(User user);
    
    Page<User> getUsers(Pageable pageable);

}
