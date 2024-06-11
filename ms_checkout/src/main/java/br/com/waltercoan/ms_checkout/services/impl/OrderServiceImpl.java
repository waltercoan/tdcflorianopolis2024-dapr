package br.com.waltercoan.ms_checkout.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.waltercoan.ms_checkout.entities.CustomerOrder;
import br.com.waltercoan.ms_checkout.repositories.CustomerOrderRepository;
import br.com.waltercoan.ms_checkout.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private CustomerOrderRepository repository;

    @Override
    public List<CustomerOrder> getAll() {
        return repository.findAll();
    }
    
}
