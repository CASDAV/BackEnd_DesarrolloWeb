package com.backend.projectodesarrolloweb.laesquinadigital.service;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.PurchaseOrderRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.util.PurchaseOrderNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repository;

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

            provider.setProduct(order.getProduct());
            provider.setAmount(order.getAmount());
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
    public PurchaseOrder createOrder(PurchaseOrder order) {

        PurchaseOrder order2 = new PurchaseOrder();
        order2.setCustomer(order.getCustomer());
        order2.setProduct(order.getProduct());
        order2.setAmount(order.getAmount());
        order2.setFinalPrice(order2.getProduct().getPrice()*order2.getAmount());
        
        return repository.save(order);

    }

    @Override
    public Page<PurchaseOrder> getOrders(Pageable pageable) {
        
        return repository.findAll(pageable);
    
    }
    
}
