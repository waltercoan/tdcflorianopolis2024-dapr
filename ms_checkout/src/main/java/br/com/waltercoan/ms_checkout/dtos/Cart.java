package br.com.waltercoan.ms_checkout.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Cart {
    private UUID id;
    private Date date;
    private List<CartItem> itens = new ArrayList<CartItem>();
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public List<CartItem> getItens() {
        return itens;
    }
    public void setItens(List<CartItem> itens) {
        this.itens = itens;
    }
    
    
}
