package com.backend.projectodesarrolloweb.laesquinadigital.service;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.Product;
import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.model.ShoppingCart;
import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.PurchaseOrderRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.util.PurchaseOrderNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repository;

    @Autowired
    private UserRepository uRepository;

    @Override
    public void deletePurchaseOrder(Long id) {

        Optional<PurchaseOrder> user = repository.findById(id);
        
        if(user.isPresent()){
            repository.delete(user.get());
        } else{
            throw new PurchaseOrderNotFoundException(id);
        }  
        
    }

    @Override
    public PurchaseOrder updateOrder(PurchaseOrder order, Long id) {
        
        return repository.findById(id).map(provider ->{

            provider.setFinalPrice(order.getFinalPrice());
            return repository.save(provider);

        }).orElseGet(()->{
            throw new PurchaseOrderNotFoundException(id);
        });
    }

    @Override
    public PurchaseOrder getOrderById(Long id) {

        return repository.findById(id).orElseThrow(()-> new PurchaseOrderNotFoundException(id));

    }

    @Override
    public PurchaseOrder createOrder(PurchaseOrder order, Long id) {

        PurchaseOrder order2 = new PurchaseOrder();
        order2.setPurchaseDate(order.getPurchaseDate());
        order2.setCustomer(uRepository.getById(id));
        order2.setCart(order.getCart());
        order2.setFinalPrice(calcFinalPrice(order.getCart()));
        return repository.save(order);

    }

    @Override
    public Page<PurchaseOrder> getOrders(Pageable pageable) {
        
        return repository.findAll(pageable);
    
    }
    

    public Double calcFinalPrice(ShoppingCart shoppingCart){
        
        Double finalprice = 0d;

        for(Product p: shoppingCart.getProducts()){
            finalprice+=p.getPrice();
        }

        return finalprice;

    }

    @Override
    public Page<PurchaseOrder> getOrdersPerUser(Long id, Pageable pageable) {

        UserSys user = uRepository.getById(id);
        return repository.findByCustomer(user, pageable);
    }
}
