package com.pluralsight;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        getInventory();
        showMenu(scanner);

    }

    public static int showMenu(Scanner scanner) {
        System.out.println("What do you want to do?");
        System.out.println("1 - List all products");
        System.out.println("2 - Lookup a product by it's id");
        System.out.println("3 - Find all products within a price range");
        System.out.println("4 - Add a new product");
        System.out.println("5 - Quit the application");
        System.out.print("Enter command: ");
        int command = scanner.nextInt();

        switch (command) {
            case 1:
                listAllItems();
                showMenu(scanner);
                break;
            case 2:
                idLookUp(scanner);
                showMenu(scanner);
                break;
            case 3:
                priceRange(scanner);
                showMenu(scanner);
                break;
            case 4:
                addNewProduct(scanner);
                showMenu(scanner);
                break;
            case 5:
                System.out.println("Quitting app...");
                break;
        }
        return command;
    }

    public static void listAllItems() {
        for(Product product : inventory) {
            int skuNum = product.getSkuNum();
            String itemName = product.getItemName();
            float price = product.getPrice();

            String productString = String.format("%d | %s | $%.2f", skuNum, itemName, price);
            System.out.println(productString);

        }
    }

    public static void idLookUp(Scanner scanner) {
        System.out.print("Enter an id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean found = false;

        for(Product product : inventory) {
            if(id == product.getSkuNum()) {
                int skuNum = product.getSkuNum();
                String itemName = product.getItemName();
                float price = product.getPrice();

                System.out.println("Item found with matching id...");
                String productString = String.format("%d | %s | $%.2f", skuNum, itemName, price);
                System.out.println(productString);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("No product found with entered id...");
        }

    }

    public static void priceRange(Scanner scanner) {
        System.out.print("What is your maximum budget? ");
        float max = scanner.nextFloat();
        System.out.print("What is your minimum budget? ");
        float min = scanner.nextFloat();

        System.out.println("The products below are in your price range...");
        for(Product product : inventory){
            int skuNum = product.getSkuNum();
            String itemName = product.getItemName();
            float price = product.getPrice();

            if(min <= product.getPrice() && max >= product.getPrice()) {
                String productString = String.format("%d | %s | $%.2f", skuNum, itemName, price);
                System.out.println(productString);
            }
        }
    }

    public static void addNewProduct(Scanner scanner) {

        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("all-products.csv", true));

            System.out.print("Enter SKU number: ");
            int skuNum = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter item name: ");
            String itemName = scanner.nextLine();
            System.out.print("Enter price: ");
            float price = scanner.nextFloat();

            Product newProduct = new Product(skuNum, itemName, price);
            inventory.add(newProduct);
            String item;
            item = String.format("%d | %s | $%.2f%n", skuNum, itemName, price);
            bufWriter.write(item);

            bufWriter.close();
        }
        catch(IOException e) {
            e.getStackTrace();
        }

    }

    public static ArrayList<Product> getInventory() {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("inventory.csv"));
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("all-products.csv"));

            String line;
            while((line = bufReader.readLine()) != null) {
                String[] details = line.split("\\|");
                int skuNum = Integer.parseInt(details[0]);
                String itemName = details[1];
                float price = Float.parseFloat(details[2]);
                Product newProduct = new Product(skuNum, itemName, price);
                inventory.add(newProduct);

                bufWriter.write(String.format("%d | %s | $%.2f%n", skuNum, itemName, price));
            }


            bufReader.close();
            bufWriter.close();
        }
        catch (IOException e) {
            e.getStackTrace();
        }

        return inventory;
    }






}
