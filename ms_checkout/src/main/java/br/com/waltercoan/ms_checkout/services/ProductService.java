package br.com.waltercoan.ms_checkout.services;

import java.util.List;
import java.util.UUID;

import br.com.waltercoan.ms_checkout.entities.Product;

public interface ProductService {
    Product save(Product product);
    List<Product> getAll();
    Product getById(UUID id);
    
}
