package com.backend.projectodesarrolloweb.laesquinadigital;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.ProductRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.PurchaseOrderRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(PurchaseOrderRepository purchaseOrderRepository, UserRepository userRepository, 
    ProductRepository productRepository){
        return args -> {
            System.out.println("Probando la capa de de  persistencia");
            User user = new User("Juanito", "Alimaña", "adsbuu@knshbd.com","123456");
            
            userRepository.save(user);

            user = new User();

            Optional<User> user2 = userRepository.loginMethod("adsbuu@knshbd.com", "123456");

            System.out.println(user2.get().getFirstName()+" "+user2.get().getLastName());

        };

    }
    
}
