package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        System.out.println("Please, add some products to your cart: add product_ID or remove product_ID\n");
        System.out.println("If you are done, please enter: exit\n");

        System.out.println("Available products:");
        ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
        productRepository.getProductList().forEach(System.out::println);

        System.out.println();

        Cart cart = (Cart) context.getBean("cart");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String clientResponse = scanner.nextLine().toLowerCase();

            try {
                if (clientResponse.startsWith("add")) {
                    cart.addProduct(Integer.parseInt(clientResponse.substring(clientResponse.indexOf(" ")).trim()));
                } else if (clientResponse.startsWith("remove")) {
                    cart.removeProduct(Integer.parseInt(clientResponse.substring(clientResponse.indexOf(" ")).trim()));
                } else if (clientResponse.equals("exit")) {
                    break;
                } else {
                    System.out.println("Massage does not any of provided examples. Try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error");
            }
        }

        cart.getCart().forEach(System.out::println);

        context.close();
    }
}
