package com.yorosoft.eexpenseapi.service;

import com.yorosoft.eexpenseapi.dto.BaseDTO;

import java.util.List;
import java.util.Optional;

public interface CrudService <T extends BaseDTO> {

    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T dto);

    void delete(Long id);

    T update(Long id, T dto);
}
