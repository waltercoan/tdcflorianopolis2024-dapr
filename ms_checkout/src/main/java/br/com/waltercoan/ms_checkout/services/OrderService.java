package br.com.waltercoan.ms_checkout.services;

import java.util.List;

import br.com.waltercoan.ms_checkout.entities.CustomerOrder;

public interface OrderService {
    List<CustomerOrder> getAll();
}
