package com.Assignment_1.InventoryManagementSystem.Repository;

import com.Assignment_1.InventoryManagementSystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("Select p from Product p where p.pID=:id")
    Product findProductById(String id);

    @Query("delete p from Product p where p.pId:id")
    void deleteProductById(String id);
}