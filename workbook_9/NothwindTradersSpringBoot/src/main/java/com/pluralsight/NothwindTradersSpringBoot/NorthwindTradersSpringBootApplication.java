package com.pluralsight.NothwindTradersSpringBoot;

import com.pluralsight.NothwindTradersSpringBoot.model.Product;
import com.pluralsight.NothwindTradersSpringBoot.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class,args);
		ProductService productService = context.getBean(ProductService.class);

		Scanner scanner = new Scanner(System.in);

		while(true){
			displayMenu();
			String input = scanner.nextLine().trim();

			switch (input){
				case "1" -> listProducts(productService);
				case "2" -> addProduct(scanner, productService);
				case "3" -> {
					return;
				}
				default -> System.out.println("Invalid Input");
			}
		}
	}

	private static void displayMenu(){
		System.out.println("\nMain Menu\nOptions:\n\t1 - List Products\n\t2 - Add Product\n\t3 - Exit");
	}

	private static void listProducts(ProductService productService){
		List<Product> products = productService.getAll();
		products.forEach(System.out::println);
	}

	private static void addProduct(Scanner scanner, ProductService productService){
		System.out.println("Enter Product ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Product Name: ");
		String name = scanner.nextLine().trim();

		System.out.println("Enter Product Category: ");
		String category = scanner.nextLine().trim();

		System.out.println("Enter Product Price: ");
		double price = scanner.nextDouble();
		scanner.nextLine();

		productService.addProduct(new Product(id,name,category,price));
	}

}
