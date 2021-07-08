package ir.example.elasticsearch_example.service;

import ir.example.elasticsearch_example.data.entity.Product;
import ir.example.elasticsearch_example.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        log.info("...createProduct called, {}...", product);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> insertBulk(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByNameUsingAnnotation(String name) {
        log.info("nameee cddc {}", name);
        return productRepository.findByNameUsingAnnotations(name);
    }

}
