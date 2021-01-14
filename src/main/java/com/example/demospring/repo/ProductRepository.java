package com.example.demospring.repo;

import com.example.demospring.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,String> {

}
