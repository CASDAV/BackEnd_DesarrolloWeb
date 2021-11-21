package com.backend.projectodesarrolloweb.laesquinadigital.rest;

import java.util.ArrayList;
import java.util.List;

import com.backend.projectodesarrolloweb.laesquinadigital.dtos.ShoppingCartDTO;
import com.backend.projectodesarrolloweb.laesquinadigital.model.ShoppingCart;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IShoppingCartService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ShoppingCarts")
public class ShoppingCartRest {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("{page}/{size}")
    public Page<ShoppingCartDTO> getShoppingCarts(@PathVariable("page") int pagina, @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(pagina, size, Sort.by("id"));

        Page<ShoppingCart> carts = shoppingCartService.getCarts(pageable);

        List<ShoppingCartDTO> res = new ArrayList<>();

        for (ShoppingCart cart : carts.getContent()) {

            res.add(mapper.map(cart, ShoppingCartDTO.class));

        }
        return new PageImpl<>(res, pageable,res.size());
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCartDTO createShoppingCart(@RequestBody ShoppingCartDTO dto){

        ShoppingCart cart = mapper.map(dto, ShoppingCart.class);

        return mapper.map(shoppingCartService.createShoppingCart(cart), ShoppingCartDTO.class);

    }

    @PutMapping(value = "actulizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCartDTO uCartDTO(@RequestBody ShoppingCartDTO dto, @PathVariable Long id){

        ShoppingCart cart = mapper.map(dto, ShoppingCart.class);

        shoppingCartService.updateShoppingCart(cart, id);

        return dto;
    }

    @DeleteMapping("delete/{id}")
    public void deleteShoppingCart(@PathVariable Long id){
        shoppingCartService.deleteShoppingCart(id);
    }

}
