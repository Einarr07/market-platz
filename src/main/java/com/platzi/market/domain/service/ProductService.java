package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAllProducts();
    }

    public Optional<Product> getById(int id){
        return productRepository.getProductById(id);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.saveProduct(product);
    }

    public boolean deleteById(int id){
       return getById(id).map(product -> {
           productRepository.deleteProduct(id);
           return true;
       }).orElse(false);
    }
}
