package com.Assignment_1.InventoryManagementSystem.Service;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.ProductDto;
import com.Assignment_1.InventoryManagementSystem.InventoryDto.StoreDto;
import com.Assignment_1.InventoryManagementSystem.Model.Store;
import com.Assignment_1.InventoryManagementSystem.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public List<StoreDto> getAllStores() {
        return storeRepository.findAll().stream().map(x->new StoreDto(x.getSId(),x.getSName(),x.getSAddress())).toList();
    }

    public Optional<Store> getStoreById(int id) {
        return storeRepository.findById(id);
    }

    public Store updateStore(Store store) {
        return storeRepository.save(store);
    }

    public void deleteStore(int id) {
        storeRepository.deleteById(id);
    }
}