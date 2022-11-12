package com.infoshareacademy.DTO;

import com.infoshareacademy.entity.product.ProductUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FridgeDto implements Serializable {
    private Long fridgeDtoId;
    private List<FridgeDto.ProductInFridgeDto> productsInFridgeDto;

    public void addProductDto(FridgeDto.ProductInFridgeDto product) {
        if(productsInFridgeDto == null){
            this.productsInFridgeDto = new ArrayList<>();
        }
        this.productsInFridgeDto.add(product);
        this.setFridgeDtoId(1L);
        product.setFridgeDto(this);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductInFridgeDto implements Serializable {
        private Long productId;
        private String productName;
        private Double amount;
        private ProductUnit unit;
        @Future
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate expirationDate;
        private FridgeDto fridgeDto;
    }
}