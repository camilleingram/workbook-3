package com.pluralsight;
import java.io.*;
import java.util.Scanner;

public class BedtimeStories {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String story = promptUser(scanner);

        try {
            FileInputStream fis = new FileInputStream(story);
            Scanner readScanner = new Scanner(fis);
            int lineCounter = 1;

            while(readScanner.hasNextLine()) {
                String input = readScanner.nextLine();
                System.out.printf("%d. %s %n", lineCounter, input);
                lineCounter++;
            }
            readScanner.close();
        }
        catch(IOException e) {
            System.out.println("That file does not exist!");
        }

    }

    public static String promptUser(Scanner scanner) {
        System.out.print("Enter the name of the story: ");
        String story = scanner.nextLine();

        return story;
    }
}
