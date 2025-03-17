package com.Assignment_1.InventoryManagementSystem.Controller;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.ProductDto;
import com.Assignment_1.InventoryManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/getAllProducts")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("getByProductId/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("updateProductById/{id}")
    public ProductDto updateProduct(@PathVariable int id, @RequestBody ProductDto productDto) {

        return productService.updateProduct(id,productDto);
    }

    @DeleteMapping("deleteProductById/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return  ResponseEntity.ok("The Product with ID "+id+" has been deleted");
    }
}