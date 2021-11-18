package com.backend.projectodesarrolloweb.laesquinadigital.service;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.ShoppingCart;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.ShoppingCartRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.util.ShoppingCartNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService implements IShoppingCartService {
    
    @Autowired
    private ShoppingCartRepository repository;

    @Override
    public void deleteShoppingCart(Long id) {
        Optional<ShoppingCart> user = repository.findById(id);
        
        if(user.isPresent()){
            repository.delete(user.get());
        } else{
            throw new ShoppingCartNotFoundException(id);
        }  
    }

    @Override
    public ShoppingCart updateShoppingCart(ShoppingCart cart, Long id) {
        return repository.findById(id).map(provider ->{

            provider.setProducts(cart.getProducts());;
            return repository.save(provider);

        }).orElseGet(()->{
            throw new ShoppingCartNotFoundException(id);
        });
    }

    @Override
    public ShoppingCart getShoppingCartById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ShoppingCartNotFoundException(id));
    }

    @Override
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        
        ShoppingCart cart = new ShoppingCart();
        cart.setUser(shoppingCart.getUser());
        cart.setProducts(shoppingCart.getProducts());

        return repository.save(cart);
    }

    @Override
    public Page<ShoppingCart> getCarts(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
}
