package com.Assignment_1.InventoryManagementSystem.utils;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.ProductDto;
import com.Assignment_1.InventoryManagementSystem.InventoryDto.StoreDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.util.StringUtils;

@Slf4j
public class ValidationUtils {

    public static void validateProductDto(ProductDto productDto) throws BadRequestException {
        if (StringUtils.isEmpty(productDto.getPName()) && StringUtils.isEmpty(productDto.getPId())) {
            log.error("Product name :{} or product id  :{} cannot be empty", productDto.getPName(), productDto.getPName());
            throw new BadRequestException("Product name" + productDto.getPName() + " or product id " +
                    productDto.getPId() + "cannot be empty");
        }
    }

    public static void validateStore(StoreDto storeDto) {
        if (StringUtils.isEmpty(storeDto.getSName())) {
            throw new IllegalArgumentException("Store name cannot be null or empty");
        }
        if (StringUtils.isEmpty(storeDto.getSId())) {
            throw new IllegalArgumentException("Store ID cannot be null or empty");
        }
    }
}
