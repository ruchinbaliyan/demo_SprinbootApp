package com.example.demospring.service.Impl;

import com.example.demospring.models.Product;
import com.example.demospring.repo.ProductRepository;
import com.example.demospring.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl() {
    }

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Create a new product and add to the Repository
     *
     * @param product
     */

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
        LOGGER.info("created a product with id {}", product.getId());
        //productRepo.put(product.getId(), product);
    }

    /**
     * Update a product
     *
     * @param id
     * @param product
     */
    @Override
    public void updateProduct(String id, Product product) {
        productRepository.delete(product);
        product.setId(id);
        productRepository.save(product);
        LOGGER.info("updated a product with id {} to new Id{}", id, product.getId());
    }

    /**
     * delete a product
     *
     * @param id
     */
    @Override
    public void deleteProduct(String id) {
           productRepository.deleteById(id);
    }

    /**
     * get all the Products
     *
     * @return
     */
    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    /**
     * get specific product details given its id
     *
     * @param id
     * @return
     */
    @Override
    public Product getProductInfo(String id) {
        Optional<Product> data = productRepository.findById(id);
        if (data.isPresent()) {
            Product product = data.get();
            return product;
        } else
            {
            LOGGER.warn("Product with the given id {} is not present ", id);
            return null;
        }
    }

    @Override
    public Collection<Product> getSortedProducts() {
        //  Comparator<Product> theSort = (Product p1,Product p2) -> p1.getId().compareTo(p2.getId());
        Comparator<Product> theSort = Comparator.comparing(Product::getName);
        List<Product> result = (List<Product>) productRepository.findAll();
        result.sort(theSort);
        return result;
    }

    @Override
    public String getCount() {
        return "total" + productRepository.count() + "items available";
    }
}
