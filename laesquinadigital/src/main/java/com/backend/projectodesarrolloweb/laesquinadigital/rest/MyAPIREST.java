package com.backend.projectodesarrolloweb.laesquinadigital.rest;

import java.util.ArrayList;
import java.util.List;

import com.backend.projectodesarrolloweb.laesquinadigital.dtos.UserDTO;
import com.backend.projectodesarrolloweb.laesquinadigital.model.User;
import com.backend.projectodesarrolloweb.laesquinadigital.dtos.ProductDTO;
import com.backend.projectodesarrolloweb.laesquinadigital.dtos.PurchaseOrderDTO;
import com.backend.projectodesarrolloweb.laesquinadigital.model.Product;
import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IProductService;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IPurchaseOrderService;
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
    public UserDTO createUser(@RequestBody UserDTO dto){
        User user = mapper.map(dto, User.class);

        return  mapper.map(usersService.createUser(user), UserDTO.class);
    }

    @GetMapping("/users/{page}/{size}")
    public Page<UserDTO> getUsers(@PathVariable("page") int pagina, @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(pagina, size, Sort.by("id"));

        Page<User> users = usersService.getUsers(pageable);

        List<UserDTO> res = new ArrayList<>(); 

        for (User user : users.getContent()){

            res.add(mapper.map(user, UserDTO.class));
            
        }
        return new PageImpl<>(res, pageable, res.size());
    }

    @PutMapping(value = "usr/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO updateUser(@RequestBody UserDTO dto, @PathVariable Long id){

        User user = mapper.map(dto, User.class);

        usersService.updateUser(user, id);

        return dto;
    }

    @DeleteMapping("user/delete/{id}")
    public void deleteUser(@PathVariable Long id){

        usersService.deleteUser(id);
    }

    @GetMapping("/purchaseorders/{page}/{size}")
    public Page<PurchaseOrderDTO> getPurchaseOrders(@PathVariable("page") int pagina, @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(pagina, size, Sort.by("id"));

        Page<PurchaseOrder> orders = purchaseOrderService.getOrders(pageable);

        List<PurchaseOrderDTO> res = new ArrayList<>(); 

        for (PurchaseOrder order : orders.getContent()){

            res.add(mapper.map(order, PurchaseOrderDTO.class));
            
        }
        return new PageImpl<>(res, pageable, res.size());
    }

    @PostMapping(value = "purchaseorders/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public PurchaseOrderDTO createPurchaseOrder(@RequestBody PurchaseOrderDTO dto){

        PurchaseOrder order = mapper.map(dto, PurchaseOrder.class);

        return  mapper.map(purchaseOrderService.createOrder(order), PurchaseOrderDTO.class);

    }

    @PutMapping(value = "purchasorders/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseOrderDTO uOrderDTO(@RequestBody PurchaseOrderDTO dto, @PathVariable Long id){

        PurchaseOrder order = mapper.map(dto, PurchaseOrder.class);

        purchaseOrderService.updateOrder(order, id);

        return dto;
    }

    @DeleteMapping("purchaseorder/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        purchaseOrderService.deletePurchaseOrder(id);
    }

    @PostMapping(value = "product/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO createProdct(@RequestBody ProductDTO dto){
        Product product = mapper.map(dto, Product.class);

        return  mapper.map(productService.createProduct(product), ProductDTO.class);
    }

    @GetMapping("products/{page}/{size}")
    public Page<ProductDTO> getProducta(@PathVariable("page") int pagina, @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(pagina, size, Sort.by("id"));

        Page<Product> products = productService.getProducts(pageable);

        List<ProductDTO> res = new ArrayList<>(); 

        for (Product product: products.getContent()){

            res.add(mapper.map(product, ProductDTO.class));
            
        }
        return new PageImpl<>(res, pageable, res.size());
    }

    @PutMapping(value = "product/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO updateProduct(@RequestBody ProductDTO dto, @PathVariable Long id){

        Product product = mapper.map(dto, Product.class);

        productService.updateProduct(product, id);

        return dto;
    }

    @DeleteMapping("product/delete/{id}")
    public void deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
    }

}
