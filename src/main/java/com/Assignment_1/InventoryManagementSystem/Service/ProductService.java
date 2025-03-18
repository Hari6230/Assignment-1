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
                   Product save = productRepository.save(productDetails);
                   return ResponseEntity.status(HttpStatus.OK).body("The Product data is Stored in Database");
               }
               else{
                   log.error("Duplicate Entry ProductId :"+productDetails.getPid());
                   throw new RuntimeException("Duplicate Entry");
               }
           }catch (BadRequestException e){
               log.error("Error occurred in ProductService :The Product is NULL");
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The product Should not be NULL");
           }

    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(p->new ProductDto(p.getPid(),p.getPName(),p.getPDesc())).collect(Collectors.toList());
    }

    public  ProductDto getProductById(String id) {
        Product product = productRepository.findProductById(id);
        if(!ObjectUtils.isEmpty(product)){
            return new ProductDto(product.getPid(),product.getPName(),product.getPDesc());
        }else{
            log.error("Error occurred While fetching Product by ID");
            throw new NoSuchElementException("The Product is not present with ID "+id);
        }

    }

    public ResponseEntity<String> updateProduct(String pId,ProductDto productDto) {
        Product product = productRepository.findProductById(pId);
        if(!ObjectUtils.isEmpty(product)){
            product.setPName(productDto.getPName());
            product.setPDesc(productDto.getPDesc());
            Product save = productRepository.save(product);
            return ResponseEntity.status(HttpStatus.OK).body("The product table is UPDATED");
        }
        else{
            log.error("Product is not present in DB");
            throw new NoSuchElementException("There is no product with id"+pId);
        }

    }

    public ResponseEntity<String> deleteProduct(String id) {
        Product product = productRepository.findProductById(id);
        if(!ObjectUtils.isEmpty(product)) {
            productRepository.deleteProductById(id);
            return ResponseEntity.status(HttpStatus.OK).body("The Product table is Updated");
        }
        else{
            throw new NoSuchElementException("There is no Product with ID "+id);
        }
    }
}
