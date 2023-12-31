package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository, 
			RepositoryRestConfiguration configuration) {
		return args->{
			configuration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null,"laptops", 2500));
			productRepository.save(new Product(null,"souris", 15));
			productRepository.save(new Product(null,"clavier", 30));
			productRepository.save(new Product(null,"serveur", 10000));
			
		};
		
	}

}
