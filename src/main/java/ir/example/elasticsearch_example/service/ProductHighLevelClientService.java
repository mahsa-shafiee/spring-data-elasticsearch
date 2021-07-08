package ir.example.elasticsearch_example.service;

import ir.example.elasticsearch_example.data.entity.Product;
import org.elasticsearch.search.SearchHit;

import java.util.List;
import java.util.Map;

public interface ProductHighLevelClientService {
    Product createProduct(Product product);

    List<Product> bulkInsert(List<Product> products);

    Product getProductById(String id);

    boolean deleteProduct(String id);

    List<Product> toProductList(SearchHit[] searchHits) throws Exception;

    Map<String, Long> aggregateTerm(String term);

    boolean createProductIndex();
}
