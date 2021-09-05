package com.yorosoft.eexpenseapi.service;

import com.yorosoft.eexpenseapi.dto.CategoryDTO;
import com.yorosoft.eexpenseapi.model.Category;
import com.yorosoft.eexpenseapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.yorosoft.eexpenseapi.mapper.CategoryMapper.INSTANCE;

@Service
@RequiredArgsConstructor
public class CategoryService implements CrudService<CategoryDTO>{

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categoryDTOS.add(INSTANCE.categoryToDto(category)));
        return categoryDTOS;
    }

    @Override
    public Optional<CategoryDTO> findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.map(INSTANCE::categoryToDto);
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        Category category = INSTANCE.dtoToCategory(dto);
        return INSTANCE.categoryToDto(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {categoryRepository.deleteById(id);}

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        Category savedCategory = categoryRepository.findById(id).orElseThrow();
        Category categoryToUpdate = INSTANCE.dtoToCategory(dto);

        savedCategory.setName(categoryToUpdate.getName());

        return INSTANCE.categoryToDto(categoryRepository.save(savedCategory));
    }
}
