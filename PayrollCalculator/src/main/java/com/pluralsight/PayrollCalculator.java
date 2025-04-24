package com.pluralsight;
import java.io.*;
import java.util.Scanner;
public class PayrollCalculator {
    static Employee[] employeeArr = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String fileName = userPrompt(scanner);
        writeEmployee(fileName);
    }

    public static String userPrompt(Scanner scanner) {
        System.out.print("Enter the name of the payroll file to create (csv extension): ");
        String fileName = scanner.nextLine();

        return fileName;
    }

    public static void writeEmployee(String fileName) {
        employeeArr = readEmployee();
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            String input;

            for(Employee employee : employeeArr) {
                float grossPay = employee.getGrossPay(employee.getHoursWorked(), employee.getPayRate());
                input = String.format("%d|%s|%.2f %n", employee.getId(), employee.getName(),
                                      grossPay);
                bufWriter.write(input);
            }
            bufWriter.close();
        }
        catch(IOException e) {
            e.getStackTrace();
        }
    }

    public static Employee[] readEmployee() {
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine();
            String input;
            int index = 0;
            employeeArr = new Employee[8];

            while ((input = bufReader.readLine()) != null) {
                String[] attributes = input.split("\\|", input.length());
                int id = Integer.parseInt(attributes[0]);
                String name = attributes[1];
                float hoursWorked = Float.parseFloat(attributes[2]);
                float payRate = Float.parseFloat(attributes[3]);
                Employee employee = new Employee(id, name, hoursWorked, payRate);
                employeeArr[index++] = employee;

            }

            bufReader.close();

        } catch (IOException e) {
            e.getStackTrace();
        }

        return employeeArr;
    }
}
