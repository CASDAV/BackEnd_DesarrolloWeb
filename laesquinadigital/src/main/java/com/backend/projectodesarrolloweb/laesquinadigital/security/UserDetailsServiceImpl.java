package com.backend.projectodesarrolloweb.laesquinadigital.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        
        Optional<UserSys> opt = userRepository.findByEmail(arg0);
        User spUser = null;

        if(opt.isPresent()){
            UserSys user = opt.get();
            List<SimpleGrantedAuthority> roles = getRoles(user);
            spUser = new User(user.getEmail(), user.getPassword(), roles);
        }else{
            throw new UsernameNotFoundException(arg0);
        }

        return spUser;
    }

    private List<SimpleGrantedAuthority> getRoles(UserSys user) {

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_"+user.getRol().getName()));

        return roles;
    }

    

}
