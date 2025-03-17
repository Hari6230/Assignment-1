package com.Assignment_1.InventoryManagementSystem.Repository;

import com.Assignment_1.InventoryManagementSystem.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, String> {
}