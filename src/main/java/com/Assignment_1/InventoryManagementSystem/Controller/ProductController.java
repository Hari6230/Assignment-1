package com.Assignment_1.InventoryManagementSystem.Controller;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.ProductDto;
import com.Assignment_1.InventoryManagementSystem.Service.ProductService;
import com.Assignment_1.InventoryManagementSystem.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/getAllProducts/")
    public ResponseEntity<Page<Product>>getAllProducts(@RequestParam int page,@RequestParam int size) {
        return productService.getAllProducts(page,size);
    }

    @GetMapping("getByProductId/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PutMapping("updateProductById/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody ProductDto productDto) {

        return productService.updateProduct(id,productDto);
    }

    @DeleteMapping("deleteProductById/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
       return productService.deleteProduct(id);
    }
}