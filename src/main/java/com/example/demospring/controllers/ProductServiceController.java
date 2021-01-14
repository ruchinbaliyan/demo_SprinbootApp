package com.example.demospring.controllers;

import com.example.demospring.exceptions.ProductNotFoundException;
import com.example.demospring.models.Product;
import com.example.demospring.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;

@RestController
@Api(value = " endpoint to manage all the products ")

public class ProductServiceController {

    @Autowired
    private ProductService productService;

    /*
    Get All the products
     */
    @RequestMapping(value = "/products")
    public Collection<Product> getProducts() {
        return productService.getProducts();

    }

    /*
    Update a product
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        if(productService.getProductInfo(id)==null)
            throw new  ProductNotFoundException("id-"+id);

        productService.updateProduct(id, product);

        return new ResponseEntity<>("product updated successfully", HttpStatus.OK);

    }

    /*
    Delete a Product
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") String id) {
        if(productService.getProductInfo(id)==null)
            throw new  ProductNotFoundException("id-"+id);

        productService.deleteProduct(id);
    }

    /*
    Create a Product
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct( @Valid @RequestBody Product product) {
        productService.createProduct(product);

       URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId()).toUri();

        return  ResponseEntity.created(location).build();

    }


    /*
    get specific product info
     */
    @RequestMapping(value = "/products/{id}")
    public Product getProductInfo(@PathVariable String id) {

        Product product = productService.getProductInfo(id);
        if(product == null)
            throw new ProductNotFoundException("id-"+id);

        return product;
    }

    /*
    Products in sorted order
     */
    @RequestMapping(value= "/products/sorted")
    public Collection<Product> getSortedProducts(){
       return productService.getSortedProducts();
    }

    /*
    total count of products
     */
    @RequestMapping(value="/products/count")
    public String totalProducts(){
        return productService.getCount();

    }

    @RequestMapping(value ="/products/param", params="version=v1")
    public Product paramV1(){
        return new Product("ravi","1");

    }

    @RequestMapping(value ="/products/param", params="version=v2")
    public Product paramV2(){
        return new Product("ruchin","2");

    }
    @RequestMapping(value ="/products/header", headers="API_VERSION=v1")
    public Product headerV1(){
        return new Product("ravi","1");

    }

    @RequestMapping(value ="/products/header", headers="API_VERSION=v2")
    public Product headerV2(){
        return new Product("ruchin","2");

    }
}



