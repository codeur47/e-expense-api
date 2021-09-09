package com.yorosoft.eexpenseapi.service;

import com.yorosoft.eexpenseapi.dto.CategoryDTO;
import com.yorosoft.eexpenseapi.model.Category;
import com.yorosoft.eexpenseapi.model.Purchase;
import com.yorosoft.eexpenseapi.repository.CategoryRepository;

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

import java.util.Collections;
import java.util.List;


import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static com.yorosoft.eexpenseapi.util.TestDataFactory.*;

@ContextConfiguration(classes = {CategoryService.class})
@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests of CategoryService class")
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    @DisplayName("Get an empty list of Category")
    void givenNoCategories_whenFindAll_thenGetEmptyList() {

        //given
        when(categoryRepository.findAll())
                .thenReturn(Collections.emptyList());

        //when
        List<CategoryDTO> categories = categoryService.findAll();

        //then
        Assertions.assertEquals(0, categories.size());
    }

    @Test
    @DisplayName("Get a list with single Categories")
    void givenSingleCategory_whenFindAll_thenGetSingleCategoryList() {

        //given
        when(categoryRepository.findAll())
                .thenReturn(getCategoryList(1L, 1L));

        //when
        List<CategoryDTO> categories = categoryService.findAll();

        //then
        Assertions.assertEquals(1, categories.size());
        Assertions.assertEquals("Category 1", categories.get(0).getName());
    }

    @Test
    void testFindAll() {
        Iterable<Category> iterable = (Iterable<Category>) mock(Iterable.class);
        doNothing().when(iterable).forEach(org.mockito.Mockito.any());
        when(this.categoryRepository.findAll()).thenReturn(iterable);
        assertTrue(this.categoryService.findAll().isEmpty());
        verify(this.categoryRepository).findAll();
        verify(iterable).forEach(org.mockito.Mockito.any());
    }

    @Test
    @DisplayName("Get a list of 500 Authors")
    void given500Categories_whenFindAll_then500CategoriesList() {

        //given
        when(categoryRepository.findAll())
                .thenReturn(getCategoryList(500L, 1L));

        //when
        List<CategoryDTO> categories = categoryService.findAll();

        //then
        Assertions.assertEquals(500, categories.size());
    }

    @Test
    void testFindById() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setName("Name");
        category.setPurchaseList(new ArrayList<Purchase>());
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<Category> ofResult = Optional.<Category>of(category);
        when(this.categoryRepository.findById((Long) org.mockito.Mockito.any())).thenReturn(ofResult);
        Optional<CategoryDTO> actualFindByIdResult = this.categoryService.findById(123L);
        assertTrue(actualFindByIdResult.isPresent());
        CategoryDTO getResult = actualFindByIdResult.get();
        assertEquals(123L, getResult.getId().longValue());
        assertNull(getResult.getPurchaseDTOS());
        assertEquals("Name", getResult.getName());
        verify(this.categoryRepository).findById((Long) org.mockito.Mockito.any());
    }

    @Test
    void testSave() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setName("Name");
        category.setPurchaseList(new ArrayList<Purchase>());
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.categoryRepository.save((Category) org.mockito.Mockito.any())).thenReturn(category);
        CategoryDTO actualSaveResult = this.categoryService.save(new CategoryDTO());
        assertEquals(123L, actualSaveResult.getId().longValue());
        assertNull(actualSaveResult.getPurchaseDTOS());
        assertEquals("Name", actualSaveResult.getName());
        verify(this.categoryRepository).save((Category) org.mockito.Mockito.any());
    }

    @Test
    void testSave2() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setName("Name");
        category.setPurchaseList(new ArrayList<Purchase>());
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.categoryRepository.save((Category) org.mockito.Mockito.any())).thenReturn(category);
        CategoryDTO categoryDTO = mock(CategoryDTO.class);
        when(categoryDTO.getName()).thenReturn("foo");
        CategoryDTO actualSaveResult = this.categoryService.save(categoryDTO);
        assertEquals(123L, actualSaveResult.getId().longValue());
        assertNull(actualSaveResult.getPurchaseDTOS());
        assertEquals("Name", actualSaveResult.getName());
        verify(this.categoryRepository).save((Category) org.mockito.Mockito.any());
        verify(categoryDTO).getName();
    }

    @Test
    void testDelete() {
        doNothing().when(this.categoryRepository).deleteById((Long) org.mockito.Mockito.any());
        this.categoryService.delete(123L);
        verify(this.categoryRepository).deleteById((Long) org.mockito.Mockito.any());
    }

    @Test
    void testUpdate() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setName("Name");
        category.setPurchaseList(new ArrayList<Purchase>());
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<Category> ofResult = Optional.<Category>of(category);

        Category category1 = new Category();
        category1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setId(123L);
        category1.setName("Name");
        category1.setPurchaseList(new ArrayList<Purchase>());
        category1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.categoryRepository.save((Category) org.mockito.Mockito.any())).thenReturn(category1);
        when(this.categoryRepository.findById((Long) org.mockito.Mockito.any())).thenReturn(ofResult);
        CategoryDTO actualUpdateResult = this.categoryService.update(123L, new CategoryDTO());
        assertEquals(123L, actualUpdateResult.getId().longValue());
        assertNull(actualUpdateResult.getPurchaseDTOS());
        assertEquals("Name", actualUpdateResult.getName());
        verify(this.categoryRepository).findById((Long) org.mockito.Mockito.any());
        verify(this.categoryRepository).save((Category) org.mockito.Mockito.any());
    }
}
