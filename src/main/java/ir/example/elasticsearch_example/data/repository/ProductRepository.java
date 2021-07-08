package ir.example.elasticsearch_example.data.repository;

import ir.example.elasticsearch_example.data.entity.Product;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByName(String name);

    List<Product> findByNameContaining(String name);

    @Query("{\"match\":{\"name\":\"?0\"}}")
    @Highlight(fields = {
            @HighlightField(name = "name")
    })
    List<Product> findByNameUsingAnnotations(String name);

//    @Query("{ \"bool\" : { \"must\" : [ {\"range\" : {\"price\" : {\"from\" : ?0, \"to\" : null, \"include_lower\" : true, \"include_upper\" : true } } } ] } }")
    List<Product> findByPriceGreaterThanEqual(double price);
}
