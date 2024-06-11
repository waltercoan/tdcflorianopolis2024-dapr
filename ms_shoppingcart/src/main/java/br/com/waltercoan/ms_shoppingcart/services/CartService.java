package br.com.waltercoan.ms_shoppingcart.services;

import java.util.UUID;

import br.com.waltercoan.ms_shoppingcart.dtos.Cart;

public interface CartService {
    Cart save(Cart cart);
    Cart findById(UUID id);
    Cart confirm(UUID id);
}
