package com.backend.projectodesarrolloweb.laesquinadigital;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import com.backend.projectodesarrolloweb.laesquinadigital.model.UserTp;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository){
        return args -> {
            System.out.println("Probando la capa de de  persistencia");
            UserTp tipo =UserTp.CUSTOMER;

            User user = new User();
            user.setName("Juanito Alimaña");
            user.setEmail("adsbuu@knshbd.com");
            user.setUserType(tipo);
            user.setPassword("123456");
            
            userRepository.save(user);

            user = new User();

            Optional<User> user2 = userRepository.findByEmailAndPassword("adsbuu@knshbd.com", "123456");

            System.out.println(user2.get().getName());

        };

    }
    
}
