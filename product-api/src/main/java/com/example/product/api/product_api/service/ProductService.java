package com.example.product.api.product_api.service;

import com.example.product.api.product_api.models.Product;
import com.example.product.api.product_api.models.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();

    public ProductService() {
        productList.add(new Product(1L, "Laptop", 1000.0, List.of(new Review(1L, "Good", 5))));
        productList.add(new Product(2L, "Phone", 500.0, List.of(new Review(2L, "Average", 3))));
    }

    public List<Product> getAllProducts(){
        return  productList;
    }

    public Product getProductById(Long id){
        return productList.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Review> getReviewByProductId(Long id){
        Product product = getProductById(id);
        return product !=null ? product.getReviews():new ArrayList<>();
    }

    public void addProduct(Product product){
        productList.add(product);
    }
}
