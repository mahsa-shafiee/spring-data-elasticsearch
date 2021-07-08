package ir.example.elasticsearch_example.web;

import ir.example.elasticsearch_example.data.entity.Product;
import ir.example.elasticsearch_example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService springDataProductService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return springDataProductService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable String id) {
        return springDataProductService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable String id) {
        springDataProductService.deleteProduct(id);
        return true;
    }

    @PostMapping("/_bulk")
    public List<Product> insertBulk(@RequestBody List<Product> products) {
        return (List<Product>) springDataProductService.insertBulk(products);
    }

    @GetMapping("/name/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return springDataProductService.getProductsByName(name);
    }

    @GetMapping("/name/{name}/annotations")
    public List<Product> findByNameAnnotations(@PathVariable String name) {
        return springDataProductService.getProductsByNameUsingAnnotation(name);
    }
}
