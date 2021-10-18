package com.backend.projectodesarrolloweb.laesquinadigital;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import com.backend.projectodesarrolloweb.laesquinadigital.model.UserTp;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.ProductRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.PurchaseOrderRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Configuration
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(PurchaseOrderRepository purchaseOrderRepository, UserRepository userRepository, 
    ProductRepository productRepository){
        return args -> {
            System.out.println("Probando la capa de de  persistencia");
            UserTp tipo =UserTp.CUSTOMER;
            //Page<PurchaseOrder> orders = purchaseOrderRepository.findAll(PageRequest.of(1, 10, Sort.by(Direction.ASC, "ID")));
            User user = new User();
            user.setFirstName("Juanito");
            user.setLastName("Alimaña");
            user.setEmail("adsbuu@knshbd.com");
            user.setUserType(tipo);
            user.setPassword("123456");
            
            userRepository.save(user);

            user = new User();

            Optional<User> user2 = userRepository.loginMethod("adsbuu@knshbd.com", "123456");

            System.out.println(user2.get().getFirstName()+" "+user2.get().getLastName());

        };

    }
    
}
