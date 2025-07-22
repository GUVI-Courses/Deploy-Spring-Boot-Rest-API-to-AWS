package com.example.product.api.product_api.controller;

import com.example.product.api.product_api.models.Product;
import com.example.product.api.product_api.models.Review;
import com.example.product.api.product_api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return product !=null ? ResponseEntity.ok(product):ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.ok("Product added sucessfully");
    }

    @GetMapping("/{id}/reviews")
    public List<Review> getProductReviews(@PathVariable Long id){
        return productService.getReviewByProductId(id);
    }



}
