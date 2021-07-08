package ir.example.elasticsearch_example.service;

import ir.example.elasticsearch_example.data.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductRestTemplateService {
    Product getProductById(String id);

    List<Product> getProductsByName(String name);

    Map<String, Long> aggregateTerm(String term);
}
