package com.yorosoft.eexpenseapi.util;

import com.yorosoft.eexpenseapi.dto.CategoryDTO;
import com.yorosoft.eexpenseapi.dto.PurchaseDTO;
import com.yorosoft.eexpenseapi.model.Category;
import com.yorosoft.eexpenseapi.model.Purchase;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class TestDataFactory {

    public static Category getSingleCategory(Long id, Long purchaseCount){
        return Category
                .builder()
                .id(id)
                .name("Category "+ id)
                .purchaseList(getPurchaseList(purchaseCount))
                .build();
    }

    public static List<Category> getCategoryList(Long categoryCount, Long purchaseCount){
        return LongStream.rangeClosed(1, categoryCount)
                .mapToObj(id -> getSingleCategory(id, purchaseCount))
                .collect(Collectors.toList());
    }

    public static CategoryDTO getSingleCategoryDTO(Long id, Long purchaseCount){
        return CategoryDTO.builder()
                .id(id)
                .name("Category "+ id)
                .purchaseDTOS(getPurchaseListDTO(purchaseCount))
                .build();
    }

    public static List<CategoryDTO> getCategoryListDTO(Long categoryCount, Long purchaseCount){
        return LongStream.rangeClosed(1, categoryCount)
                .mapToObj(id -> getSingleCategoryDTO(id, purchaseCount))
                .collect(Collectors.toList());
    }

    public static Purchase getSinglePurchase(Long id){
        return Purchase.builder()
                .id(id)
                .name("Purchase "+ id)
                .description("Description "+ id)
                .quantity(2)
                .price(new BigDecimal(10))
                .total(new BigDecimal(20))
                .build();
    }

    public static List<Purchase> getPurchaseList(Long purchaseCount){
        return LongStream.rangeClosed(1, purchaseCount)
                .mapToObj(TestDataFactory::getSinglePurchase)
                .collect(Collectors.toList());
    }

    public static PurchaseDTO getSinglePurchaseDTO(Long id){
        return PurchaseDTO.builder()
                .id(id)
                .name("Purchase "+ id)
                .description("Description "+ id)
                .quantity(2)
                .price(new BigDecimal(10))
                .total(new BigDecimal(20))
                .build();
    }

    public static List<PurchaseDTO> getPurchaseListDTO(Long purchaseCount){
        return LongStream.rangeClosed(1, purchaseCount)
                .mapToObj(TestDataFactory::getSinglePurchaseDTO)
                .collect(Collectors.toList());
    }

}
