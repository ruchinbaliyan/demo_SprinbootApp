package com.example.demospring.service;

import com.example.demospring.models.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface ProductService {

    void createProduct(Product product);

    void updateProduct(String id, Product product);

    void deleteProduct(String id);

    List<Product> getProducts();

    Product getProductInfo(String id);

    Collection<Product> getSortedProducts();

    String getCount();
}
