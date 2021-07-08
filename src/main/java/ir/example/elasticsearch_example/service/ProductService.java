package ir.example.elasticsearch_example.service;

import ir.example.elasticsearch_example.data.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional<Product> getProduct(String id);

    void deleteProduct(String id);

    Iterable<Product> insertBulk(List<Product> products);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByNameUsingAnnotation(String name);
}
