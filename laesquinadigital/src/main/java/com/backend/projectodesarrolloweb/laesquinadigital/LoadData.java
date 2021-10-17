package com.backend.projectodesarrolloweb.laesquinadigital;

import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
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

            User user = new User();
            user.setName("Juanito Alimaña");
            user.setEmail("adsbuu@knshbd.com");
            user.setPassword("123456");
            
            userRepository.save(user);

            user = new User();

            userRepository.findByEmailAndPassword("adsbuu@knshbd.com", "123456");

        };

    }
    
}
