package com.in28minutes.microservices.currencyexchangeservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplicationH2 {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplicationH2.class, args);
	}

//	@Bean
//	public Tracer tracer() {
//		Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv()
//				.withType(ConstSampler.TYPE)
//				.withParam(1);
//
//		Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv()
//				.withLogSpans(true);
//
//		Configuration config = new Configuration("name-generator-service")
//				.withSampler(samplerConfig)
//				.withReporter(reporterConfig);
//
//		return config.getTracer();
//	}
}
