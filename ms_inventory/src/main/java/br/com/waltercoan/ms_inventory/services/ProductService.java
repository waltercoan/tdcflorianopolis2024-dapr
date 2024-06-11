package br.com.waltercoan.ms_inventory.services;

import java.util.List;
import java.util.UUID;

import br.com.waltercoan.ms_inventory.entities.Product;

public interface ProductService {
    List<Product> getAll();
    Product getById(UUID id);
    Product save(Product product);
    
}
