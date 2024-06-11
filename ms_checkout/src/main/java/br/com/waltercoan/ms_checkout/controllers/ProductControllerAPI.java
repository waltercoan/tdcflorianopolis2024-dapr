package br.com.waltercoan.ms_checkout.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.waltercoan.ms_checkout.entities.Product;
import br.com.waltercoan.ms_checkout.services.ProductService;
import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;

@RestController
@RequestMapping("/products")
public class ProductControllerAPI {
    
    @Autowired
    private ProductService service;

    @Topic(name = "${ms_inventory.topic.product}", pubsubName = "${ms_inventory.service}")
    @PostMapping(path = "/topic-product", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Product> post(@RequestBody CloudEvent<Product> cloudEvent){
        var product = service.save(cloudEvent.getData());
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> get(){
        var listProducts = service.getAll();
        return new ResponseEntity<>(listProducts,HttpStatus.OK);
    }

}
