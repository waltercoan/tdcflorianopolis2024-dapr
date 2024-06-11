package br.com.waltercoan.ms_inventory.controllers;

import java.util.List;
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

import br.com.waltercoan.ms_inventory.entities.Product;
import br.com.waltercoan.ms_inventory.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductControllerAPI {
    
    @Autowired
    private ProductService service;
    
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<List<Product>>(service.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable UUID id){
        var product = service.getById(id);
        if(product != null)
            return new ResponseEntity<Product>(product,HttpStatus.OK);

        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Product> post(@RequestBody Product product){
        service.save(product);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
    

}
