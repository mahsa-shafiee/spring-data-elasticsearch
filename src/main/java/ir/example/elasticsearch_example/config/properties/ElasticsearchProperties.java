package ir.example.elasticsearch_example.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@ConfigurationProperties("elasticsearch")
@Data
public class ElasticsearchProperties {
    private String[] hostAndPort;
    private Duration socketTimeout;
    private Duration connectTimeout;
}
