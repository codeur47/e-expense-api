package com.yorosoft.eexpenseapi.service;

import com.yorosoft.eexpenseapi.dto.PurchaseDTO;
import com.yorosoft.eexpenseapi.model.Purchase;
import com.yorosoft.eexpenseapi.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.yorosoft.eexpenseapi.mapper.PurchaseMapper.INSTANCE;

@Service
@RequiredArgsConstructor
public class PurchaseService implements CrudService<PurchaseDTO> {

    private final PurchaseRepository purchaseRepository;

    @Override
    public List<PurchaseDTO> findAll() {
        List<PurchaseDTO> purchaseDTOList = new ArrayList<>();
        purchaseRepository.findAll().forEach(purchase -> purchaseDTOList.add(INSTANCE.purchaseToDto(purchase)));
        return purchaseDTOList;
    }

    @Override
    public Optional<PurchaseDTO> findById(Long id) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        return optionalPurchase.map(INSTANCE::purchaseToDto);
    }

    @Override
    public PurchaseDTO save(PurchaseDTO dto) {
        Purchase purchase = INSTANCE.dtoToPurchase(dto);
        return INSTANCE.purchaseToDto(purchaseRepository.save(purchase));
    }

    @Override
    public void delete(Long id) {purchaseRepository.deleteById(id);}

    @Override
    public PurchaseDTO update(Long id, PurchaseDTO dto) {
        Purchase savedPurchase = purchaseRepository.findById(id).orElseThrow();
        Purchase purchaseToUpdate = INSTANCE.dtoToPurchase(dto);

        savedPurchase.setName(purchaseToUpdate.getName());
        savedPurchase.setDescription(purchaseToUpdate.getDescription());
        savedPurchase.setPrice(purchaseToUpdate.getPrice());
        savedPurchase.setQuantity(purchaseToUpdate.getQuantity());
        savedPurchase.setTotal(purchaseToUpdate.getTotal());

        return INSTANCE.purchaseToDto(purchaseRepository.save(savedPurchase));
    }
}
