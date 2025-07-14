package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.IPurchaseRepository;
import com.platzi.market.persistence.crud.ICompraCrudRepository;
import com.platzi.market.persistence.entity.Compra;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements IPurchaseRepository {

    @Autowired
    private ICompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClientId(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
