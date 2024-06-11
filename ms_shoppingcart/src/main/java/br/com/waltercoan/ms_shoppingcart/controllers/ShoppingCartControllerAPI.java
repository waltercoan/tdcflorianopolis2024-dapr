package br.com.waltercoan.ms_shoppingcart.controllers;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.waltercoan.ms_shoppingcart.dtos.Cart;
import br.com.waltercoan.ms_shoppingcart.services.CartService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartControllerAPI {

    @Autowired
    private CartService service;

    @PostMapping
    public ResponseEntity<Cart> post(@RequestBody Cart cart){
        cart = service.save(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> get(@PathVariable UUID id){
        try {
            var cart = service.findById(id);
            if(cart != null){
                return new ResponseEntity<Cart>(cart, HttpStatus.OK);
            }
        } catch (NullPointerException e) {
        } 
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/confirm/{id}")
    public ResponseEntity<Cart> confirm(@PathVariable UUID id){
        try {
            var cart = service.confirm(id);
            if(cart != null){
                return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
            } 
        } catch (NullPointerException e) {
        } 
        return ResponseEntity.notFound().build();
    }
}
