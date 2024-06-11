package br.com.waltercoan.ms_checkout.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.waltercoan.ms_checkout.dtos.Cart;
import br.com.waltercoan.ms_checkout.entities.CustomerOrder;
import br.com.waltercoan.ms_checkout.services.CheckoutService;

@RestController
@RequestMapping("/checkout")
public class CheckoutControllerAPI {
    
    @Autowired
    private CheckoutService service;

    @PostMapping
    public ResponseEntity<CustomerOrder> post(@RequestBody Cart cart){
        var order = service.confirm(cart);
        return new ResponseEntity<CustomerOrder>(order,HttpStatus.OK);
    }
}