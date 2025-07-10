package com.platzi.market.domain.repository;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAllPurchases();
    Optional<List<Purchase>> getByClientId(String clientId);
    Purchase save(Purchase purchase);
}
