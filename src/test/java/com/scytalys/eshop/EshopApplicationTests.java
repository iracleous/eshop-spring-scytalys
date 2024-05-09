package com.scytalys.eshop;

import com.scytalys.eshop.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EshopApplicationTests {

	@Autowired
	private ProductController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
