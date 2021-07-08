package ir.example.elasticsearch_example.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "product")
@TypeAlias("product-class")
public class Product {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Long)
    private double price;

    @Field(type = FieldType.Integer)
    private Integer quantity;

    @Field(type = FieldType.Object)
    @CreatedBy
    private Manufacturer manufacturer;

    @Field(type = FieldType.Keyword)
    private Category category;

    public enum Category {
        ART,
        GAMES,
        FASHION
    }
}
