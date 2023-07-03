package com.microservices.demo.elastic.model.index.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.demo.elastic.model.index.IIndexModel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.ZonedDateTime;

@Data
@Builder
@Document(indexName = "twitter-index")
public class TwitterIndexModel implements IIndexModel {
    @JsonProperty
    private String id;
    @JsonProperty
    private Long userId;
    @JsonProperty
    private String text;

    @Field(type = FieldType.Date,format= {},pattern="uuuu-MM-dd'T'HH:mm:ssZZ")
    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "uuuu-MM-dd'T'HH:mm:ssZZ")
    private ZonedDateTime createdAt;


}
