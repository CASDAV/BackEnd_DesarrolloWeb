package com.backend.projectodesarrolloweb.laesquinadigital;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.ProductRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.PurchaseOrderRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadData {
    
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args ->{
            UserSys customer = new UserSys();
            customer.setEmail("testEmail@test.com");
            customer.setPassword(passwordEncoder.encode("12345"));
            userRepository.save(customer);
        };
    }
}
    