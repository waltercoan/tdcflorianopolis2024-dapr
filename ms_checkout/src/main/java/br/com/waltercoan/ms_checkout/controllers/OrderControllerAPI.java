package br.com.waltercoan.ms_checkout.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.waltercoan.ms_checkout.entities.CustomerOrder;
import br.com.waltercoan.ms_checkout.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderControllerAPI {
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<CustomerOrder>> get(){
        var listOrders = service.getAll();
        return new ResponseEntity<List<CustomerOrder>>(listOrders,HttpStatus.OK);
    }
}
