package com.example.demospring.controllers;

import com.example.demospring.models.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class ProductServiceControllerTest {

    @Test
    public void testGetProductWithoutAnyProduct() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8081 + "/products";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains(""));
    }

    @Test
    public void testCreateProduct() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8081 + "/products";
        URI uri = new URI(baseUrl);

        Product product = new Product("1", "apple");

        ResponseEntity<String> result = restTemplate.postForEntity(uri, product, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("new product added"));

    }

    @Test
    public void testGetProductWithOneProduct() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8081 + "/products";
        URI uri = new URI(baseUrl);

        Product product = new Product("1", "apple");

        restTemplate.postForEntity(uri, product, String.class);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains(""));
    }
}


