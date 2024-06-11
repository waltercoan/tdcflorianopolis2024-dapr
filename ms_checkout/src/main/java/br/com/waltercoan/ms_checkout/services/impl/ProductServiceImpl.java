package br.com.waltercoan.ms_checkout.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.waltercoan.ms_checkout.entities.Product;
import br.com.waltercoan.ms_checkout.repositories.ProductRepository;
import br.com.waltercoan.ms_checkout.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(UUID id) {
        var result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }
    
}
