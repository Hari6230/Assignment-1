package com.Assignment_1.InventoryManagementSystem.Service;

import com.Assignment_1.InventoryManagementSystem.Exceptions.AllExceptionHandler;
import com.Assignment_1.InventoryManagementSystem.InventoryDto.StoreDto;
import com.Assignment_1.InventoryManagementSystem.entity.Store;
import com.Assignment_1.InventoryManagementSystem.Repository.StoreRepository;
import com.Assignment_1.InventoryManagementSystem.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public String createStore(StoreDto storeDto) {
        try {
            ValidationUtils.validateStore(storeDto);
            Store s = storeRepository.findByStoreId(storeDto.getSId());
            if(!ObjectUtils.isEmpty(s)){
                return "The Store is already Present ";
            }
            Store store = new Store(storeDto.getId(), storeDto.getSId(), storeDto.getSName(), storeDto.getSAddress());
            Store save = storeRepository.save(store);
            return "The store is created Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating store: " + e.getMessage());
        }
    }

    public List<StoreDto> getAllStores() {
        try {
            return storeRepository.findAll().stream()
                    .map(x -> StoreDto.builder().id(x.getId()).sId(x.getSId()).sAddress(x.getSAddress()).sName(x.getSName()).build())
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching all stores: " + e.getMessage());
        }
    }

    public StoreDto getStoreById(String id) {
        try {
            Store s = storeRepository.findByStoreId(id);
            if(ObjectUtils.isEmpty(s)){
                throw new NoSuchElementException(" there is no Such Store with id "+id);
            }
            return StoreDto.builder().id(s.getId()).sId(s.getSId()).sName(s.getSName()).sAddress(s.getSAddress()).build();

        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching store by id: " + e.getMessage());
        }
    }

    public String updateStore(Store store) {
        try {
            if(ObjectUtils.isEmpty(store)){
                throw new NoSuchElementException("there is no Store With id "+store.getSId());
            }
            storeRepository.save(store);
            return " the Store is Updated Successfully";

        } catch (Exception e) {
            throw new AllExceptionHandler("There is an error while Updating the store");
        }
    }

    public String deleteStore(String id) {
        try {
            storeRepository.deleteById(id);
            return "the Store with the id "+ id + " is Deleted";

        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting store: " + e.getMessage());
        }
    }
}