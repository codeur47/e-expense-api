package com.yorosoft.eexpenseapi.service;

import com.yorosoft.eexpenseapi.dto.CategoryDTO;
import com.yorosoft.eexpenseapi.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static com.yorosoft.eexpenseapi.util.TestDataFactory.*;

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
}
