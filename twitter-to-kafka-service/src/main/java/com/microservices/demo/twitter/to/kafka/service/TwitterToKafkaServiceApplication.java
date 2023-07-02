package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.init.IStreamInitializer;
import com.microservices.demo.twitter.to.kafka.service.runner.IStreamRunner;
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



    private final IStreamRunner streamRunner;

    private final IStreamInitializer streamInitializer;


    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App starts...");
        streamInitializer.init();
        streamRunner.start();
    }
}
