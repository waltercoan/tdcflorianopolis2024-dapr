package br.com.waltercoan.ms_shoppingcart.services.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.waltercoan.ms_shoppingcart.dtos.Cart;
import br.com.waltercoan.ms_shoppingcart.dtos.CartItem;
import br.com.waltercoan.ms_shoppingcart.dtos.Product;
import br.com.waltercoan.ms_shoppingcart.services.CartService;
import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;


@Service
public class CartServiceImpl implements CartService{
    private static final Logger log = LoggerFactory.getLogger(CartServiceImpl.class);
    @Autowired
    private DaprClient daprClient;
    private static final String INVENTORY_SERVICE_APP_ID = "ms_inventory";
    private static final String CHECKOUT_SERVICE_APP_ID = "ms_checkout";
    private static final String STATE_STORE_NAME = "statestore";

    @Override
    public Cart save(Cart cart) {
        
        if(cart.getId() == null){
            cart.setId(UUID.randomUUID());
            log.warn(String.format("SAVE UPDATE ID: %s", cart.getId()));
        }
        for(CartItem item : cart.getItens()){
            var prod = checkProduct(item.getProduct().getId());
            if(prod != null){
                item.setId(UUID.randomUUID());
                item.getProduct().setDescription(prod.getDescription());
                item.getProduct().setPrice(prod.getPrice());
                log.warn(String.format("SAVE UPDATE PRODUCT ID: %s", prod.getId()));
            }else{
                item.setId(null);
            }
        }
        var filterList = cart.getItens().stream().filter(i -> i.getId() != null);
        cart.setItens(filterList.toList());
        
        daprClient.saveState(STATE_STORE_NAME, cart.getId().toString(), cart).block();

        log.warn(String.format("SAVE CART ID: %s", cart.getId()));
        return cart;
    }
    private Product checkProduct(UUID id){
        try{
            var response = daprClient.invokeMethod(INVENTORY_SERVICE_APP_ID, String.format("products/%s",id.toString()), null, HttpExtension.GET,null,Product.class).block();
            return response;
        }catch(Exception e){
            log.warn(String.format("FAIL CHECKPRODUCT ID: %s", id));
            return null;
        }
    }
    @Override
    public Cart findById(UUID id) {
        var cart = daprClient.getState(STATE_STORE_NAME, id.toString(), Cart.class).block().getValue();
        log.warn(String.format("GET CART ID: %s", cart.getId().toString()));
        return cart;
    }
    @Override
    public Cart confirm(UUID id) {
        var cart = findById(id);
        if(cart != null){
            try{
                var response = daprClient.invokeMethod(CHECKOUT_SERVICE_APP_ID, "checkout", cart, HttpExtension.POST,null,Cart.class).block();
                log.warn(String.format("CONFIRM CART ID: %s", id.toString()));    
                daprClient.deleteState(STATE_STORE_NAME, id.toString()).block();
                log.warn(String.format("DELETE CART ID: %s", id.toString()));
            }catch(Exception e){}
            return cart;
        } 
        return null;
    }

    
}
