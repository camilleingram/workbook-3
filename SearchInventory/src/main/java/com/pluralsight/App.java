package com.pluralsight;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

    }

    public static int showMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1 - List all products");
        System.out.println("2 - Lookup a product by it's id");
        System.out.println("3 - Find all products within a price range");
        System.out.println("4 - Add a new product");
        System.out.println("5 - Quit the application");
        System.out.println("Enter command: ");
        int command = scanner.nextInt();

        switch (command) {
            case 5:
                System.out.println("Quitting application...");
        }
        return command;
    }

    public static ArrayList<Product> listAllProducts() {
        ArrayList<Product> inventory = new ArrayList<>();

        Product product1 = new Product(1110, "Broom", 20.99f);
        Product product2 = new Product(1111, "Milk", 4.59f);
        Product product3 = new Product(1112, "Chair", 167.98f);
        Product product4 = new Product(1113, "TV", 592.99f);
        Product product5 = new Product(1114, "Fish", 16.98f);

        inventory.add(product1);
        inventory.add(product2);
        inventory.add(product3);
        inventory.add(product4);
        inventory.add(product5);

        for(Product product : inventory) {

        }

        return products;


    }


}
