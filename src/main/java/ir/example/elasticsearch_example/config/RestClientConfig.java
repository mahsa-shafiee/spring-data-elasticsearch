/*
package ir.example.elasticsearch_example.config;

import ir.example.elasticsearch_example.config.properties.ElasticsearchProperties;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "ir.example.elasticsearch_example.dto")
@EnableElasticsearchAuditing
@RequiredArgsConstructor
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    private final ElasticsearchProperties elasticsearchProperties;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticsearchProperties.getHostAndPort())
                .withConnectTimeout(elasticsearchProperties.getConnectTimeout())
                .withSocketTimeout(elasticsearchProperties.getSocketTimeout())
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
*/
