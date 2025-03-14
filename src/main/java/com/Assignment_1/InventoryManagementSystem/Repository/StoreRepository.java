package com.Assignment_1.InventoryManagementSystem.Repository;

import com.Assignment_1.InventoryManagementSystem.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
}