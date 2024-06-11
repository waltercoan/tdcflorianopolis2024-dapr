package br.com.waltercoan.ms_shoppingcart.dtos;

import java.util.UUID;

public class Product {
    private UUID id;
    private String description;
    private float price;

    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("id: %s - Description: %s", this.getId(), this.getDescription());
    }
}
