package com.yorosoft.eexpenseapi.controller;

import com.yorosoft.eexpenseapi.config.CrudControllerAPIPath;
import com.yorosoft.eexpenseapi.dto.PurchaseDTO;
import com.yorosoft.eexpenseapi.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CrudControllerAPIPath.PURCHASE_BASE_URL)
public class PurchaseController extends CrudController<PurchaseDTO> {
    public PurchaseController(CrudService<PurchaseDTO> crudService) {
        super(crudService);
    }
}
