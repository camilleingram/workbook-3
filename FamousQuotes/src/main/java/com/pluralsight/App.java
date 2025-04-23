package com.pluralsight;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String[] famousQuotes = new String[10];
        famousQuotes[0] = "It always seems impossible until it\'s done - Nelson Mandela";
        famousQuotes[1] = "Stay hungry, stay foolish. - Steve Jobs";
        famousQuotes[2]= "Happiness is not something ready-made. It comes from your own actions -" +
                         " Dalai Lama";
        famousQuotes[3]= "If I\'m gonna tell a real story, I\'m gonna start with my name. - " +
                         "Kendrick Lamar";
        famousQuotes[4]= "Change the world by being yourself. - Amy Poehler";
        famousQuotes[5]= "Tomorrow is now. - Eleanor Roosevelt";
        famousQuotes[6]= "You must expect great things of yourself before you can do them. - " +
                         "Michale Jordan";
        famousQuotes[7]= "Everything you can imagine is real. - Pablo Picasso";
        famousQuotes[8]= "Normality is a paved road: it\'s comfortable to walk but no flowers " +
                         "grow. - Vincent van Gogh";
        famousQuotes[9]= "Simplicity is the ultimate sophistication. - Leonardo da Vinci";

        int quote = userPrompt(scanner);
        int randomQuote = (int) (Math.random() * famousQuotes.length);


        try {
            System.out.println(famousQuotes[quote]);
            String answer = anotherQuote(scanner);

            while(answer.equalsIgnoreCase("yes")) {
                quote++;
                try {
                    System.out.println(famousQuotes[quote]);
                }catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You are out of Bounds");
                    answer = anotherQuote(scanner);
                    if(answer.equalsIgnoreCase("yes")) {
                        System.out.println(famousQuotes[randomQuote]);
                    } else {
                        System.out.print("Exiting out of quotes...");
                        break;
                    }
                    quote = randomQuote;
                }

                answer = anotherQuote(scanner);

            }
            System.out.print("Exiting out of quotes...");
        } catch (ArrayIndexOutOfBoundsException e) {
            String answer = anotherQuote(scanner);
            System.out.println("You are out of Bounds");
            exceptionLogic(answer, famousQuotes, randomQuote);

        }



    }

    public static void exceptionLogic(String answer, String[] famousQuotes, int randomQuote) {
        if(answer.equalsIgnoreCase("yes")) {
            System.out.println(famousQuotes[randomQuote]);
        } else {
            System.out.println("Exiting out of quotes...");
        }
    }

    public static String anotherQuote(Scanner scanner) {
        System.out.print("Would you like to see another quote? ");
        String answer = scanner.nextLine();
        return answer;
    }

    public static int userPrompt(Scanner scanner) {
        System.out.print("Select a number (1 - 10): ");
        int quote = scanner.nextInt();
        scanner.nextLine();

        return --quote;
    }
}
