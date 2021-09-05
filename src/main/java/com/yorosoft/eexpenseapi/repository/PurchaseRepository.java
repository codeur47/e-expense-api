package com.yorosoft.eexpenseapi.repository;

import com.yorosoft.eexpenseapi.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> { }
