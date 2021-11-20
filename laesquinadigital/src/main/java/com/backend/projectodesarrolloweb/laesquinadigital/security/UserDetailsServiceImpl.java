package com.backend.projectodesarrolloweb.laesquinadigital.security;

import java.util.Optional;
import static java.util.Collections.emptyList;

import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        
        Optional<UserSys> opt = userRepository.findByEmail(arg0);
        User spUser = null;

        if(opt.isPresent()){
            UserSys user = opt.get();
            spUser = new User(user.getEmail(), user.getPassword(), emptyList());
        }else{
            throw new UsernameNotFoundException(arg0);
        }

        return spUser;
    }

    
}
