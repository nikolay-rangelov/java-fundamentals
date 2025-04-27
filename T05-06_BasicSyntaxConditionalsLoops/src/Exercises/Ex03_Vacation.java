package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex03_Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int people = Integer.parseInt(sc.nextLine());
        String group = sc.nextLine().toLowerCase();
        String day = sc.nextLine().toLowerCase();
        double price = 0.0;
        switch (day) {
            case "friday":
                if (group.equals("students")) {
                    price = 8.45;
                } else if (group.equals("business")) {
                    price = 10.90;
                } else if (group.equals("regular")) {
                    price = 15.0;
                }
                break;
            case "saturday":
                if (group.equals("students")) {
                    price = 9.80;
                } else if (group.equals("business")) {
                    price = 15.60;
                } else if (group.equals("regular")) {
                    price = 20.00;
                }
                break;
            case "sunday":
                if (group.equals("students")) {
                    price = 10.46;
                } else if (group.equals("business")) {
                    price = 16;
                } else if (group.equals("regular")) {
                    price = 22.50;
                }
                break;
        }
        double total = price * people;
        if (group.equals("students") && people >= 30) {
            total *= 0.85;
        }
        if (group.equals("business") && people >= 100) {
            total = total - 10 * price;
        }
        if (group.equals("regular") && people >= 10 && people <= 20) {
            total = total * 0.95;
        }
        System.out.printf("Total price: %.2f", total);
    }
}
