package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex09_Orders {

    public static double calculateAndPrintAmount(double price, int days, int capsuls) {
        double amount = price * days * capsuls;
        System.out.printf("The price for the coffee is: $%.2f%n", amount);
        return amount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int orders = Integer.parseInt(sc.nextLine());
        double amountSum = 0;
        for (int i = 0; i < orders; i++) {
            double price = Double.parseDouble(sc.nextLine());
            int days = Integer.parseInt(sc.nextLine());
            int capsuls = Integer.parseInt(sc.nextLine());
            amountSum += calculateAndPrintAmount(price, days, capsuls);
        }
        System.out.printf("Total: $%.2f%n", amountSum);
    }
}
