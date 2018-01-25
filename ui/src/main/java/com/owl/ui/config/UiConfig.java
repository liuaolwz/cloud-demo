package com.owl.ui.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UiConfig {
  @LoadBalanced
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
