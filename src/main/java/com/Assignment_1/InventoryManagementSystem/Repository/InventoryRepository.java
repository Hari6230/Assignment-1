package com.Assignment_1.InventoryManagementSystem.Repository;

import com.Assignment_1.InventoryManagementSystem.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
