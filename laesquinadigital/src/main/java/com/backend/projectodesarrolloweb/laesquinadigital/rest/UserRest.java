package com.backend.projectodesarrolloweb.laesquinadigital.rest;

import java.util.ArrayList;
import java.util.List;

import com.backend.projectodesarrolloweb.laesquinadigital.dtos.UserDTO;
import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IUsersService;

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
@RequestMapping("Users")
public class UserRest {
    
    @Autowired
    private IUsersService usersService;

    @Autowired
    private ModelMapper mapper;
    
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO createUser(@RequestBody UserDTO dto){
        User user = mapper.map(dto, User.class);

        return  mapper.map(usersService.createUser(user), UserDTO.class);
    }

    @GetMapping("{page}/{size}")
    public Page<UserDTO> getUsers(@PathVariable("page") int pagina, @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(pagina, size, Sort.by("id"));

        Page<User> users = usersService.getUsers(pageable);

        List<UserDTO> res = new ArrayList<>(); 

        for (User user : users.getContent()){

            res.add(mapper.map(user, UserDTO.class));
            
        }
        return new PageImpl<>(res, pageable, res.size());
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO updateUser(@RequestBody UserDTO dto, @PathVariable Long id){

        User user = mapper.map(dto, User.class);

        usersService.updateUser(user, id);

        return dto;
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id){

        usersService.deleteUser(id);
    }
}
