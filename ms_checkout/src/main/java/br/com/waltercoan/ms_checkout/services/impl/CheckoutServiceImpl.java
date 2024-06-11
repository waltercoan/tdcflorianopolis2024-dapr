package br.com.waltercoan.ms_checkout.services.impl;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.waltercoan.ms_checkout.dtos.Cart;
import br.com.waltercoan.ms_checkout.dtos.CartItem;
import br.com.waltercoan.ms_checkout.entities.CustomerOrder;
import br.com.waltercoan.ms_checkout.entities.OrderItem;
import br.com.waltercoan.ms_checkout.repositories.CustomerOrderRepository;
import br.com.waltercoan.ms_checkout.services.CheckoutService;
import br.com.waltercoan.ms_checkout.services.ProductService;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private static final Logger log = LoggerFactory.getLogger(CheckoutServiceImpl.class);

    @Autowired
    private CustomerOrderRepository repository;
    @Autowired
    private ProductService productService;

    @Override
    public CustomerOrder confirm(Cart cart) {

        var order = new CustomerOrder();
        order.setId(UUID.randomUUID());
        order.setCartId(cart.getId());
        order.setDate(new Date());

        for(CartItem cartItem : cart.getItens()){
            var item = new OrderItem();

            var product = productService.getById(cartItem.getProduct().getId());
            if(product != null){
                log.warn(String.format("FOUND PROD ID %s",product.getId().toString()));
                item.setPrice(cartItem.getPrice());
                item.setQtd(cartItem.getQtd());    
                item.setProduct(product);
                order.getItens().add(item);
            }else{
                log.warn("NOT !!! FOUND PROD ID");
            }
        }
        
        order = repository.save(order);
        
        log.warn(String.format("SAVE CUSTOMER ORDER ID %s",order.getId().toString()));
        return order;
    }    
}
