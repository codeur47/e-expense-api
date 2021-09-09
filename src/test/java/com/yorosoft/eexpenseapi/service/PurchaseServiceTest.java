package com.yorosoft.eexpenseapi.service;

import com.yorosoft.eexpenseapi.dto.PurchaseDTO;
import com.yorosoft.eexpenseapi.model.Category;
import com.yorosoft.eexpenseapi.model.Purchase;
import com.yorosoft.eexpenseapi.repository.PurchaseRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import org.springframework.test.context.ContextConfiguration;

import static com.yorosoft.eexpenseapi.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {PurchaseService.class})
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

    @Test
    void testFindAll() {
        Iterable<Purchase> iterable = (Iterable<Purchase>) mock(Iterable.class);
        doNothing().when(iterable).forEach(any());
        when(this.purchaseRepository.findAll()).thenReturn(iterable);
        assertTrue(this.purchaseService.findAll().isEmpty());
        verify(this.purchaseRepository).findAll();
        verify(iterable).forEach(any());
    }

    @Test
    void testFindById() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setName("Name");
        category.setPurchaseList(new ArrayList<Purchase>());
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));

        Purchase purchase = new Purchase();
        purchase.setTotal(BigDecimal.valueOf(42L));
        purchase.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setId(123L);
        purchase.setName("Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        purchase.setPrice(valueOfResult);
        purchase.setQuantity(1);
        purchase.setDescription("The characteristics of someone or something");
        purchase.setCategory(category);
        purchase.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<Purchase> ofResult = Optional.<Purchase>of(purchase);
        when(this.purchaseRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<PurchaseDTO> actualFindByIdResult = this.purchaseService.findById(123L);
        assertTrue(actualFindByIdResult.isPresent());
        PurchaseDTO getResult = actualFindByIdResult.get();
        assertEquals("The characteristics of someone or something", getResult.getDescription());
        BigDecimal total = getResult.getTotal();
        assertEquals(valueOfResult, total);
        assertEquals(1, getResult.getQuantity());
        assertEquals(123L, getResult.getId().longValue());
        BigDecimal price = getResult.getPrice();
        assertEquals(total, price);
        assertEquals("Name", getResult.getName());
        assertEquals("42", price.toString());
        assertEquals("42", total.toString());
        verify(this.purchaseRepository).findById((Long) any());
    }

    @Test
    void testSave() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setName("Name");
        category.setPurchaseList(new ArrayList<Purchase>());
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));

        Purchase purchase = new Purchase();
        purchase.setTotal(BigDecimal.valueOf(42L));
        purchase.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setId(123L);
        purchase.setName("Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        purchase.setPrice(valueOfResult);
        purchase.setQuantity(1);
        purchase.setDescription("The characteristics of someone or something");
        purchase.setCategory(category);
        purchase.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.purchaseRepository.save((Purchase) any())).thenReturn(purchase);
        PurchaseDTO actualSaveResult = this.purchaseService.save(new PurchaseDTO());
        assertEquals("The characteristics of someone or something", actualSaveResult.getDescription());
        BigDecimal total = actualSaveResult.getTotal();
        assertEquals(valueOfResult, total);
        assertEquals(1, actualSaveResult.getQuantity());
        assertEquals(123L, actualSaveResult.getId().longValue());
        BigDecimal price = actualSaveResult.getPrice();
        assertEquals(total, price);
        assertEquals("Name", actualSaveResult.getName());
        assertEquals("42", price.toString());
        assertEquals("42", total.toString());
        verify(this.purchaseRepository).save((Purchase) any());
    }

    @Test
    void testSave2() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setName("Name");
        category.setPurchaseList(new ArrayList<Purchase>());
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));

        Purchase purchase = new Purchase();
        purchase.setTotal(BigDecimal.valueOf(42L));
        purchase.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setId(123L);
        purchase.setName("Name");
        purchase.setPrice(BigDecimal.valueOf(42L));
        purchase.setQuantity(1);
        purchase.setDescription("The characteristics of someone or something");
        purchase.setCategory(category);
        purchase.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.purchaseRepository.save((Purchase) any())).thenReturn(purchase);
        PurchaseDTO purchaseDTO = mock(PurchaseDTO.class);
        when(purchaseDTO.getTotal()).thenReturn(BigDecimal.valueOf(42L));
        when(purchaseDTO.getQuantity()).thenReturn(1);
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        when(purchaseDTO.getPrice()).thenReturn(valueOfResult);
        when(purchaseDTO.getDescription()).thenReturn("foo");
        when(purchaseDTO.getName()).thenReturn("foo");
        PurchaseDTO actualSaveResult = this.purchaseService.save(purchaseDTO);
        assertEquals("The characteristics of someone or something", actualSaveResult.getDescription());
        BigDecimal total = actualSaveResult.getTotal();
        assertEquals(valueOfResult, total);
        assertEquals(1, actualSaveResult.getQuantity());
        assertEquals(123L, actualSaveResult.getId().longValue());
        BigDecimal price = actualSaveResult.getPrice();
        assertEquals(total, price);
        assertEquals("Name", actualSaveResult.getName());
        assertEquals("42", price.toString());
        assertEquals("42", total.toString());
        verify(this.purchaseRepository).save((Purchase) any());
        verify(purchaseDTO).getDescription();
        verify(purchaseDTO).getName();
        verify(purchaseDTO).getPrice();
        verify(purchaseDTO).getQuantity();
        verify(purchaseDTO).getTotal();
    }

    @Test
    void testDelete() {
        doNothing().when(this.purchaseRepository).deleteById((Long) any());
        this.purchaseService.delete(123L);
        verify(this.purchaseRepository).deleteById((Long) any());
    }

    @Test
    void testUpdate() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setName("Name");
        category.setPurchaseList(new ArrayList<Purchase>());
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));

        Purchase purchase = new Purchase();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        purchase.setTotal(valueOfResult);
        purchase.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setId(123L);
        purchase.setName("Name");
        purchase.setPrice(BigDecimal.valueOf(42L));
        purchase.setQuantity(1);
        purchase.setDescription("The characteristics of someone or something");
        purchase.setCategory(category);
        purchase.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<Purchase> ofResult = Optional.<Purchase>of(purchase);

        Category category1 = new Category();
        category1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setId(123L);
        category1.setName("Name");
        category1.setPurchaseList(new ArrayList<Purchase>());
        category1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));

        Purchase purchase1 = new Purchase();
        purchase1.setTotal(BigDecimal.valueOf(42L));
        purchase1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase1.setId(123L);
        purchase1.setName("Name");
        purchase1.setPrice(BigDecimal.valueOf(42L));
        purchase1.setQuantity(1);
        purchase1.setDescription("The characteristics of someone or something");
        purchase1.setCategory(category1);
        purchase1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.purchaseRepository.save((Purchase) any())).thenReturn(purchase1);
        when(this.purchaseRepository.findById((Long) any())).thenReturn(ofResult);
        PurchaseDTO actualUpdateResult = this.purchaseService.update(123L, new PurchaseDTO());
        assertEquals("The characteristics of someone or something", actualUpdateResult.getDescription());
        BigDecimal total = actualUpdateResult.getTotal();
        assertEquals(valueOfResult, total);
        assertEquals(1, actualUpdateResult.getQuantity());
        assertEquals(123L, actualUpdateResult.getId().longValue());
        BigDecimal price = actualUpdateResult.getPrice();
        assertEquals(valueOfResult, price);
        assertEquals("Name", actualUpdateResult.getName());
        assertEquals("42", price.toString());
        assertEquals("42", total.toString());
        verify(this.purchaseRepository).findById((Long) any());
        verify(this.purchaseRepository).save((Purchase) any());
    }
}
