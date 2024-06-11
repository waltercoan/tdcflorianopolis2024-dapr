package br.com.waltercoan.ms_inventory.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Product {
    @Id
    private UUID id;
    private String description;
    private float price;
    private String category;

    
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    
}
