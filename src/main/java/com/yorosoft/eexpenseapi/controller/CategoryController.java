package com.yorosoft.eexpenseapi.controller;

import com.yorosoft.eexpenseapi.config.CrudControllerAPIPath;
import com.yorosoft.eexpenseapi.dto.CategoryDTO;
import com.yorosoft.eexpenseapi.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CrudControllerAPIPath.CATEGORY_BASE_URL)
public class CategoryController extends CrudController<CategoryDTO>{
    public CategoryController(CrudService<CategoryDTO> crudService) {
        super(crudService);
    }
}
