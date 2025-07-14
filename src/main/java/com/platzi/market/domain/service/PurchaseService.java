package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private IPurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.getAllPurchases();
    }

    public Optional<List<Purchase>> getByClienteId(String clientId){
        return purchaseRepository.getByClientId(clientId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

}
