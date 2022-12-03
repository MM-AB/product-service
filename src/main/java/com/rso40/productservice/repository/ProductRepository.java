package com.rso40.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rso40.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
}
