package com.pluralsight;
import java.io.*;
public class PayrollCalculator {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine();
            String input;

            while((input = bufReader.readLine()) != null) {
                String[] attributes = input.split("\\|", input.length());
                int id = Integer.parseInt(attributes[0]);
                String name = attributes[1];
                float hoursWorked = Float.parseFloat(attributes[2]);
                float payRate = Float.parseFloat(attributes[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                float grossPay = employee.getGrossPay(hoursWorked, payRate);
                System.out.printf("Employee id: %d ", id);
                System.out.printf("Employee name: %s ", name);
                System.out.printf("Hours Worked: %.2f ", hoursWorked);
                System.out.printf("Pay rate: $%.2f ", payRate);
                System.out.printf("Gross pay: $%.2f %n", grossPay);

            }

            bufReader.close();

        }
        catch(IOException e) {
            System.out.print("That file does not exist!");
        }
    }
}
