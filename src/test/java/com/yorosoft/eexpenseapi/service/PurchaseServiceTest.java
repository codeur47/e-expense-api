package com.yorosoft.eexpenseapi.service;

import com.yorosoft.eexpenseapi.dto.PurchaseDTO;
import com.yorosoft.eexpenseapi.repository.PurchaseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.yorosoft.eexpenseapi.util.TestDataFactory.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests of PurchaseService class")
class PurchaseServiceTest {

    @Mock
    private PurchaseRepository purchaseRepository;

    @InjectMocks
    private PurchaseService purchaseService;

    @Test
    @DisplayName("Get a list with single Purchases")
    void givenSinglePurchase_whenFindAll_thenGetSinglePurchaseList() {

        //given
        when(purchaseRepository.findAll())
                .thenReturn(getPurchaseList(1L));

        //when
        List<PurchaseDTO> purchasesToDtos = purchaseService.findAll();

        //then
        Assertions.assertEquals(1, purchasesToDtos.size());
    }
}
