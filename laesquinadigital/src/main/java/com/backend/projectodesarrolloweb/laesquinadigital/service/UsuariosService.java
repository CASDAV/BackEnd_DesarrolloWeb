package com.backend.projectodesarrolloweb.laesquinadigital.service;


import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.util.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    private UserRepository repository;

    @Override
    public void deleteUser(Long id) {

        Optional<User> user = repository.findById(id);

        if(user.isPresent()){

            repository.delete(user.get());

        } else{

            throw new UserNotFoundException(id);
        
        }       
    
    }

    @Override
    public User getUserById(Long id) {

        return repository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    
    }

    @Override
    public User createUser(User user) {

        return repository.save(user);

    }
    
    @Override
    public User updateUser(User user, Long id) {

        return repository.findById(id).map(provider ->{

            provider.setName(user.getName());
            provider.setBirthDate(user.getBirthDate());
            provider.setEmail(user.getEmail());
            provider.setPassword(user.getPassword());
            provider.setPassword(user.getPassword());

            return repository.save(provider);

        }).orElseGet(()->{

            throw new UserNotFoundException(id);

        });
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {

        return repository.findAll(pageable);
        
    }
    
}
