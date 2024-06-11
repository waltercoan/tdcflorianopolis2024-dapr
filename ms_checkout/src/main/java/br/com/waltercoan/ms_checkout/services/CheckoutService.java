package br.com.waltercoan.ms_checkout.services;

import br.com.waltercoan.ms_checkout.dtos.Cart;
import br.com.waltercoan.ms_checkout.entities.CustomerOrder;

public interface CheckoutService {
    CustomerOrder confirm(Cart cart);
}
