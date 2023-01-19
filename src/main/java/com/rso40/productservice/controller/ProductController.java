package com.rso40.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rso40.productservice.dto.ProductRequest;
import com.rso40.productservice.dto.ProductResponse;
import com.rso40.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    
    //End point
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody  ProductRequest productRequest){
        //System.out.println("Post mapping");
        //System.out.println(productRequest);
        productService.createProduct(productRequest);
    }

    /*@GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getAllProd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_list");
        List<ProductResponse> listProducts = productService.getAllProducts();
        modelAndView.getModelMap().addAttribute("listProducts",listProducts);
        return modelAndView;
    }*/

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        List <ProductResponse> products = productService.getAllProducts();
        //System.out.println(products);
        return products;//productService.getAllProducts();
    }

    /*@GetMapping("/new-product")
    public ModelAndView addNewProduct(ProductRequest productRequest){
        System.out.println("Get mapping");
        System.out.println(productRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new_product_form");
        return modelAndView;
    }*/

}
