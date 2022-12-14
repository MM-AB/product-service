package com.rso40.productservice.service;

import org.springframework.stereotype.Service;

import com.rso40.productservice.dto.ProductRequest;
import com.rso40.productservice.dto.ProductResponse;
import com.rso40.productservice.model.Product;
import com.rso40.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .restaurant(productRequest.getRestaurant())
            .address(productRequest.getAddress())
            .price(productRequest.getPrice())
            .build();

        productRepository.save(product);
        log.info("Product {} is saved.", product.getId());
    }


    public List<ProductResponse> getAllProducts(){
       List<Product> products = productRepository.findAll();

       return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .restaurant(product.getRestaurant())
            .address(product.getAddress())
            .price(product.getPrice())
            .build();
    }
    
}
