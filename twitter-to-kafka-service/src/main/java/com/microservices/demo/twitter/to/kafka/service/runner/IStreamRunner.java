package com.microservices.demo.twitter.to.kafka.service.runner;

import twitter4j.TwitterException;

public interface IStreamRunner {

    void start() throws TwitterException;
}
