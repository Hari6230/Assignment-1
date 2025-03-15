package com.Assignment_1.InventoryManagementSystem.Service;

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

    public StoreDto createStore(StoreDto storeDto) {
        Store store=new Store(storeDto.getSId(),storeDto.getSName(),storeDto.getSAddress());
        Store save = storeRepository.save(store);
        return new StoreDto(save.getSId(),save.getSName(),save.getSAddress());

    }

    public List<StoreDto> getAllStores() {
        return storeRepository.findAll().stream().map(x->new StoreDto(x.getSId(),x.getSName(),x.getSAddress())).toList();
    }

    public Optional<Store> getStoreById(String id) {
        return storeRepository.findById(id);
    }

    public Store updateStore(Store store) {
        return storeRepository.save(store);
    }

    public void deleteStore(String id) {
        storeRepository.deleteById(id);
    }
}