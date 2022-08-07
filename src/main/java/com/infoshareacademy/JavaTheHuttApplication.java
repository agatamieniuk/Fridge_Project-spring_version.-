package com.infoshareacademy;

import com.infoshareacademy.entity.fridge.Fridge;
import com.infoshareacademy.entity.product.Product;
import com.infoshareacademy.repository.FridgeRepository;
import com.infoshareacademy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaTheHuttApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaTheHuttApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception{
		Product product1 = new Product("Jablko", 3.0);
		Product product2 = new Product("Jajko", 10.0);

		productRepository.save(product1);
		productRepository.save(product2);

	}

}
