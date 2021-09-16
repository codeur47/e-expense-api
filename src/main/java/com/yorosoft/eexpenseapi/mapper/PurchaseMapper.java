package com.yorosoft.eexpenseapi.mapper;

import com.yorosoft.eexpenseapi.dto.PurchaseDTO;
import com.yorosoft.eexpenseapi.dto.PurchaseResponseDTO;
import com.yorosoft.eexpenseapi.model.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PurchaseMapper {

    PurchaseMapper INSTANCE = Mappers.getMapper(PurchaseMapper.class);

    PurchaseDTO purchaseToDto(Purchase purchase);
    Purchase dtoToPurchase(PurchaseDTO purchaseDTO);

    List<Purchase> dtosToPurchases(List<PurchaseDTO> purchaseDTOS);
    List<PurchaseDTO> purchasesToDtos(List<Purchase> purchases);

    PurchaseResponseDTO purchaseToResponseDto(Purchase purchase);
    List<PurchaseResponseDTO> purchasesToResponseDtos(List<Purchase> purchases);
}
