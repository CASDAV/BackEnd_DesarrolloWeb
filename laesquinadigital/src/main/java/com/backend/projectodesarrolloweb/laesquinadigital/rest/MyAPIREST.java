package com.backend.projectodesarrolloweb.laesquinadigital.rest;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.dtos.UserDTO;
import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IProductService;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IPurchaseOrderService;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IUsersService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MyApiREST {
    

    @Autowired
    private IProductService productService;

    @Autowired
    private IPurchaseOrderService purchaseOrderService;

    @Autowired
    private IUsersService usersService;

    @Autowired
    private ModelMapper mapper;


    @GetMapping("/loggin/{email}/{password}")
    public UserDTO ingresar(@PathVariable("email") String email, @PathVariable("password") String password){

        User user = usersService.loginUserService(email, password);

        return mapper.map(user, UserDTO.class);

    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO crateUser(@RequestBody UserDTO dto){
        User user = mapper.map(dto, User.class);

        return  mapper.map(usersService.createUser(user), UserDTO.class);
    }


}
