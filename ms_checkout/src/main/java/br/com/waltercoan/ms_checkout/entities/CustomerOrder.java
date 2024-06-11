package br.com.waltercoan.ms_checkout.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CustomerOrder {
    @Id
    private UUID id;
    private UUID cartId;
    private Date date;
    
    @JsonIgnoreProperties(value = {"options"})
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> itens = new ArrayList<OrderItem>();
    
    public UUID getCartId() {
        return cartId;
    }
    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }
    
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
    public List<OrderItem> getItens() {
        return itens;
    }
    public void setItens(List<OrderItem> itens) {
        this.itens = itens;
    }

    
}
