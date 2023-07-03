package com.microservices.demo.elastic.index.client.service.impl;

import com.microservices.demo.elastic.index.client.repository.TwitterElasticSearchIndexRepository;
import com.microservices.demo.elastic.index.client.service.ElasticIndexClient;
import com.microservices.demo.elastic.model.index.impl.TwitterIndexModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/*
* Elastic Search save Index Second way with repo like jpa
* **It is conditionally uses if elastic-config.is-repository configuration is true
*   Otherwise TwitterElasticIndexClient uses as IndexClient
* */
@Service
@RequiredArgsConstructor
@Slf4j
@ConditionalOnProperty(name = "elastic-config.is-repository", havingValue = "true", matchIfMissing = true)
public class TwitterElasticRepositoryIndexClient implements ElasticIndexClient<TwitterIndexModel> {
    private final TwitterElasticSearchIndexRepository twitterElasticSearchIndexRepository;

    @Override
    public List<String> save(List<TwitterIndexModel> documents) {
        List<TwitterIndexModel> repositoryResponse = (List<TwitterIndexModel>) twitterElasticSearchIndexRepository.saveAll(documents);
        List<String> documentIds = repositoryResponse.stream().map(TwitterIndexModel::getId).collect(Collectors.toList());
        log.info("Documents indexed successfully with type: {} and ids: {}", TwitterIndexModel.class.getName(), documentIds);
        return documentIds;
    }
}
