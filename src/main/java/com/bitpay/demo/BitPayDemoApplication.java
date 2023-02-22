package com.bitpay.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter(
	type = FilterType.ANNOTATION,
	classes = DependencyInjection.class)
)
public class BitPayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitPayDemoApplication.class, args);
	}

}
