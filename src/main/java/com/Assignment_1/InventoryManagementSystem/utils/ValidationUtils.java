package com.Assignment_1.InventoryManagementSystem.utils;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.util.StringUtils;


@Slf4j
public class ValidationUtils {

    public static void validateProductDto(ProductDto productDto) throws BadRequestException {
        if(StringUtils.isEmpty(productDto.getPName()) && StringUtils.isEmpty(productDto.getPId())){
            log.error("Product name :{} or product id  :{} cannot be empty", productDto.getPName(),productDto.getPName());
            throw  new BadRequestException("Product name" + productDto.getPName() + " or product id " +
                    productDto.getPId()  + "cannot be empty");
        }
    }

}
