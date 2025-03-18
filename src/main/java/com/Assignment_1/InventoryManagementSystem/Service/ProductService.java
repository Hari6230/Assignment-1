package com.Assignment_1.InventoryManagementSystem.Service;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.ProductDto;
import com.Assignment_1.InventoryManagementSystem.entity.Product;
import com.Assignment_1.InventoryManagementSystem.Repository.ProductRepository;
import com.Assignment_1.InventoryManagementSystem.utils.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public ResponseEntity<String> createProduct(ProductDto productDto) {
           try {
               ValidationUtils.validateProductDto(productDto);
               Product productDetails = productRepository.findProductById(productDto.getPId());
               if(ObjectUtils.isEmpty(productDetails)){
                   productRepository.save(productDetails);
               }
               else{
                   log.error("");
               }
           }catch (BadRequestException e){
               log.error("Error occurred in ProductService :The Product is NULL");
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The product Should not be NULL");
           }


    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(x->new ProductDto(x.getPid(),x.getPName(),x.getPDesc())).collect(Collectors.toList());
    }

    public  ProductDto getProductById(int id) {
       Product p = productRepository.findById(id).orElseThrow(()->new NoSuchElementException("There is no product with ID "+id));
       return new ProductDto(p.getPid(),p.getPName(),p.getPDesc());
    }

    public ProductDto updateProduct(int pId,ProductDto productDto) {
        //TODO:Checking the product with id (pId) before updating
        Product product = productRepository.findById(pId).orElseThrow(() -> new NoSuchElementException("There is no product with ID " + pId));
        //TODO:Setting new values to existing product (if it exist)
        product.setPName(productDto.getPName());
        product.setPDesc(productDto.getPDesc());

        Product save = productRepository.save(product);
        return new ProductDto(save.getPid(),save.getPName(),save.getPDesc());

    }

    public void deleteProduct(int id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("There is no Product with ID "+id);
        }
    }
}
