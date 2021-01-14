package com.example.demospring.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Product implements Comparable<Product> {

    @Id
    private String id;

    @Size(min=2,message = "product name  must be more than 1 character ")
    private String name;

    public Product() {
    }

    public Product(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Product p) {
        return this.getId().compareTo(p.getId());
    }

}


