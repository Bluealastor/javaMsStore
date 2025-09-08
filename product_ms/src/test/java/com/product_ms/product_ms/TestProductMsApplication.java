package com.product_ms.product_ms;

import org.springframework.boot.SpringApplication;

public class TestProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductMsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
