package com.Assignment_1.InventoryManagementSystem.Service;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.ProductDto;
import com.Assignment_1.InventoryManagementSystem.entity.Product;
import com.Assignment_1.InventoryManagementSystem.Repository.ProductRepository;
import com.Assignment_1.InventoryManagementSystem.utils.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
               Product productDetails = productRepository.findByProductId(productDto.getPId());
               if(ObjectUtils.isEmpty(productDetails)){
                   Product product=new Product(productDto.getPId(),productDto.getPName(),productDto.getPDesc());
                   productRepository.save(product);
                   return ResponseEntity.status(HttpStatus.OK).body("The Product created successfully");
               }
               else{
                   log.error("Duplicate Entry with ProductId {}:",productDetails.getProductId());
                   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate Entry with ProductId "+productDetails.getProductId());
               }
           }catch (Exception e){
               log.error("Error occurred in ProductService =>{}",e.getMessage());
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
           }

    }

    public ResponseEntity<Page<Product>>getAllProducts(int page,int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> all = productRepository.findAll(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(all);

    }

    public  ResponseEntity<ProductDto> getProductById(String id) {
        Product product = productRepository.findByProductId(id);
        if(!ObjectUtils.isEmpty(product)){
            ProductDto productDto = new ProductDto(product.getProductId(), product.getProductName(), product.getProductDescription());
            return ResponseEntity.status(HttpStatus.OK).body(productDto);
        }else{
            log.error("Product with ID {} is not present",id);
            throw new NoSuchElementException("The Product is not present with ID "+id);
        }

    }

    public ResponseEntity<String> updateProduct(String pId,ProductDto productDto) {
        Product product = productRepository.findByProductId(pId);
        if(!ObjectUtils.isEmpty(product)){
            product.setProductId(productDto.getPName());
            product.setProductDescription(productDto.getPDesc());
            Product save = productRepository.save(product);
            return ResponseEntity.status(HttpStatus.OK).body("The product table is UPDATED");
        }
        else{
            log.error("Product with ID {} is not present",pId);
            throw new NoSuchElementException("There is no product with id"+pId);
        }

    }

    public ResponseEntity<String> deleteProduct(String id) {
        Product product = productRepository.findByProductId(id);
        if(!ObjectUtils.isEmpty(product)) {
            productRepository.deleteByProductId(id);
            return ResponseEntity.status(HttpStatus.OK).body("The Product table is Updated");
        }
        else{
            log.error("Product with ID {} is not present",id);
            throw new NoSuchElementException("There is no Product with ID "+id);
        }
    }
}
