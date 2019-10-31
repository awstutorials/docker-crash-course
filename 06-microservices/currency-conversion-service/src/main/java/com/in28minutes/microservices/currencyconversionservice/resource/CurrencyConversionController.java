package com.in28minutes.microservices.currencyconversionservice.resource;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${value.from.file}")
	private String restUrl;
	//private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		LOGGER.info("Received Request to convert from {} {} to {}. ", quantity, from, to);
		CurrencyConversionBean response = restTemplate.getForObject(restUrl+"/currency-exchange/from/"+from+"/to/"+to, CurrencyConversionBean.class);

		//CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

		BigDecimal convertedValue = quantity.multiply(response.getConversionMultiple());

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				convertedValue);
	}
}
