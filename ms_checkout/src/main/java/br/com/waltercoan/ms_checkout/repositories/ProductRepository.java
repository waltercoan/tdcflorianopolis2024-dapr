package br.com.waltercoan.ms_checkout.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.waltercoan.ms_checkout.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,UUID>{
    
}
