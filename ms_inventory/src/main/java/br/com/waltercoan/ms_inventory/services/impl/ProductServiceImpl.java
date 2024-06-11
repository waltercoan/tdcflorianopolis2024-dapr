package br.com.waltercoan.ms_inventory.services.impl;

import java.util.List;
import java.util.UUID;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.waltercoan.ms_inventory.entities.Product;
import br.com.waltercoan.ms_inventory.repositories.ProductRepository;
import br.com.waltercoan.ms_inventory.services.ProductService;
import io.dapr.client.DaprClient;

import org.slf4j.Logger;

@Service
public class ProductServiceImpl implements ProductService{
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    
    @Autowired
    private ProductRepository repository;
    @Value("${ms_inventory.topic.product}")
    private String TOPIC_NAME;
    @Value("${ms_inventory.service}")
    private String PUBSUB_NAME;
    @Autowired
    private DaprClient daprClient;
    
    @Override
    public List<Product> getAll() {
        log.warn("GETALL");
        return repository.findAll();
    }

    @Override
    public Product getById(UUID id) {
        log.warn(String.format("GETBYID %s",id.toString()));
        var optional = repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } 
        return null;
    }

    @Override
    public Product save(Product product) {
        product.setId(UUID.randomUUID());
        repository.save(product);
        publicProductEvent(product);
        log.warn(String.format("SAVE %s",product.getId().toString()));
        return product;
    }

    private void publicProductEvent(Product product){
        daprClient.publishEvent(
					PUBSUB_NAME,
					TOPIC_NAME,
					product).block();
        log.warn(String.format("PUBLISH EVENT PRODUCT %s",product.getId().toString()));
    }
    
}
