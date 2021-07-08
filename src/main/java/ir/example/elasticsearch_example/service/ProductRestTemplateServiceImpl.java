package ir.example.elasticsearch_example.service;

import ir.example.elasticsearch_example.data.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductRestTemplateServiceImpl implements ProductRestTemplateService {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public Product getProductById(String id) {
        SearchHits<Product> searchHits = elasticsearchRestTemplate
                .search(new CriteriaQuery(new Criteria("id").is(id)), Product.class);
        return searchHits.get().map(SearchHit::getContent).findFirst().orElse(null);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", name))
                .build();
        SearchHits<Product> searchHits = elasticsearchRestTemplate.search(query, Product.class);

        return searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> aggregateTerm(String term) {
        Query query = new NativeSearchQueryBuilder()
                .addAggregation(new TermsAggregationBuilder(term).field(term).size(10))
                .build();

        SearchHits<Product> searchHits = elasticsearchRestTemplate.search(query, Product.class);
        Map<String, Long> result = new HashMap<>();
        Objects.requireNonNull(searchHits.getAggregations()).asList().forEach(aggregation ->
                ((Terms) aggregation).getBuckets().forEach(bucket -> result.put(bucket.getKeyAsString(), bucket.getDocCount())));

        return result;
    }

}
