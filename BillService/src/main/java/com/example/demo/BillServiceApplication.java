package com.example.demo;

import com.example.demo.beans.CustomerBean;
import com.example.demo.beans.ProductBean;
import com.example.demo.model.Bill;
import com.example.demo.model.ProductItem;
import com.example.demo.proxies.InventoryServiceProxy;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.example.demo.proxies.CustomerServiceProxy;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@AllArgsConstructor
	public class BillServiceApplication implements CommandLineRunner {
	    CustomerServiceProxy customerServiceProxy;
		BillRepository billRepository;
	    InventoryServiceProxy inventoryServiceProxy;
		ProductItemRepository productItemRepository;

		public static void main(String[] args) {
			SpringApplication.run(BillServiceApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {

			// Question 1
			CustomerBean customer = customerServiceProxy.findCustomerById(1L);
			System.out.println(customer);

			// Question 2 et 3
			Bill bill = new Bill();
			bill.setBillingdate(new Date());
			bill.setCustomerID(1L);
			bill.setCustomer(customer);
			billRepository.save(bill);

			// Question 4
			ProductBean p1=inventoryServiceProxy.findProductById(1L);
			ProductBean p2=inventoryServiceProxy.findProductById(2L);
			ProductBean p3=inventoryServiceProxy.findProductById(3L);
			System.out.println(p1.getId()+" "+p1.getName());
			System.out.println(p2.getId()+" "+p2.getName());
			ProductItem pi1=new ProductItem();
			pi1.setProductId(p1.getId());
			pi1.setPrice(3000);
			pi1.setQuantite(50);
			ProductItem pi2=new ProductItem();
			pi2.setProductId(p2.getId());
			pi2.setPrice(4000);
			pi2.setQuantite(60);
			ProductItem pi3=new ProductItem();
			pi3.setProductId(p3.getId());
			pi3.setPrice(7000);
			pi3.setQuantite(40);
			pi1.setBill(bill);
			pi2.setBill(bill);
			pi3.setBill(bill);
			productItemRepository.save(pi1);
			productItemRepository.save(pi2);
			productItemRepository.save(pi3);
		}

	}