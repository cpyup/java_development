package com.pluralsight.NothwindTradersSpringBoot4;

import com.pluralsight.NothwindTradersSpringBoot4.model.Product;
import com.pluralsight.NothwindTradersSpringBoot4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class NorthwindTradersCommandLine implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args){

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nMain Menu\nOptions:\n\t1 - List Products\n\t2 - Add Product\n\t3 - Exit");
            String input = scanner.nextLine().trim();

            switch (input){
                case "1" -> listProducts();
                case "2" -> addProduct(scanner);
                case "3" -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid Input");
            }
        }
    }

    private void listProducts(){
        List<Product> products = productService.getAll();
        products.forEach(System.out::println);
    }

    private void addProduct(Scanner scanner){
        System.out.println("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Product Name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Enter Product Category: ");
        int category = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        productService.addProduct(new Product(id,name,category,price));
    }
}
