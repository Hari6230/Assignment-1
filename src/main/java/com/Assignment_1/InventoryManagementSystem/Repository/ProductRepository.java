package com.Assignment_1.InventoryManagementSystem.Repository;

import com.Assignment_1.InventoryManagementSystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}