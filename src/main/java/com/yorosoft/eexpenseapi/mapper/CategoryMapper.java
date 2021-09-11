package com.yorosoft.eexpenseapi.mapper;

import com.yorosoft.eexpenseapi.dto.CategoryDTO;
import com.yorosoft.eexpenseapi.dto.CategoryRequestDTO;
import com.yorosoft.eexpenseapi.dto.CategoryResponseDTO;
import com.yorosoft.eexpenseapi.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToDto(Category category);
    Category dtoToCategory(CategoryDTO categoryDTO);

    List<Category> dtosToCategories(List<CategoryDTO> categoryDTOS);
    List<CategoryDTO> categoriesToDtos(List<Category> categories);

    CategoryRequestDTO categoryToRequestDto(Category category);
    Category requestDtoToCategory(CategoryRequestDTO categoryRequestDTO);

    List<CategoryResponseDTO> categoriesToResponseDtos(List<Category> categories);
}
