package com.in28minutes.microservices.currencyconversionservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests().anyRequest().permitAll()
        .and()
        .httpBasic().disable()
        .csrf().disable();
  }

  @Bean
  public RestTemplate restTemplate() {

    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

    factory.setConnectTimeout(3000);
    factory.setReadTimeout(3000);

    return new RestTemplate(factory);
  }
}