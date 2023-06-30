package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@ComponentScan(basePackages = "com.microservices.demo")
public class   TwitterToKafkaServiceApplication implements CommandLineRunner {


    private final TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;
    private final StreamRunner streamRunner;



    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App starts...");
        log.info(twitterToKafkaServiceConfigData.getWellcomeMessage());
        log.info(twitterToKafkaServiceConfigData.getTwitterV2BearerToken());
        log.info(Arrays.toString(twitterToKafkaServiceConfigData.getTwitterKeywords().toArray(new String[0])));
        streamRunner.start();
    }
}
