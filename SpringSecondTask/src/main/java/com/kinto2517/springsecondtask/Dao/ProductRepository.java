package com.kinto2517.springsecondtask.Dao;

import com.kinto2517.springsecondtask.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}