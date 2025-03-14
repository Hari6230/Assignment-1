package com.Assignment_1.InventoryManagementSystem.Service;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.ProductDto;
import com.Assignment_1.InventoryManagementSystem.Model.Product;
import com.Assignment_1.InventoryManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public ProductDto createProduct(ProductDto productDto) {
        //TODO:Taking  productDto and Converting  to product
        Product p=new Product(productDto.getPName(),productDto.getPDesc());
        //TODO:Saving product in database
        productRepository.save(p);
        //TODO:Returning ProductDto as  response
        return new ProductDto(p.getPid(),p.getPName(),p.getPDesc());
}

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(x->new ProductDto(x.getPid(),x.getPName(),x.getPDesc())).collect(Collectors.toList());
    }

    public  ProductDto getProductById(int id) {
       Product p = productRepository.findById(id).orElseThrow(()->new NoSuchElementException("There is no product like that"));
       return new ProductDto(p.getPid(),p.getPName(),p.getPDesc());
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
