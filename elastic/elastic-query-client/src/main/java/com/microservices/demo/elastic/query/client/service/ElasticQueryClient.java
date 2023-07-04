package com.microservices.demo.elastic.query.client.service;

import com.microservices.demo.elastic.model.index.IIndexModel;

import java.util.List;

public interface ElasticQueryClient<T extends IIndexModel> {
    T getIndexModelById(String id);
    List<T> getIndexModelByText(String text);
    List<T> getAllIndexModels();
}
