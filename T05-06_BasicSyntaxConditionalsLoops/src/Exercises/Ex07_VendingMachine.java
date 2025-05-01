package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex07_VendingMachine {
    static double balance = 0;

    public static boolean enoughBalanceToPurchase(double price) {
        boolean isEnough = false;
        if (balance - price >= 0) {
            isEnough = true;
        }
        return isEnough;
    }

    public static void doTransaction (double price, String product) {
        if (enoughBalanceToPurchase(price)) {
            balance -= price;
            System.out.printf("Purchased %s%n", product);
        } else {
            System.out.println("Sorry, not enough money");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        String input = null;

        do {
            input = sc.nextLine().toLowerCase();
            if (!input.equals("start")) {
                double inCoin = Double.parseDouble(input);
                if (inCoin == 0.1 || inCoin == 0.2 || inCoin == 0.5 || inCoin == 1 || inCoin == 2) {
                    balance += inCoin;
                } else {
                    System.out.printf("Cannot accept %.2f%n", inCoin);
                }
            }
        } while (!input.equals("start"));

        do {
            input = sc.nextLine().toLowerCase();
            if (!input.equals("end")) {
                switch (input) {
                    case "nuts":
                        doTransaction(2.0, "Nuts");
                        break;
                    case "water":
                        doTransaction(0.7, "Water");
                        break;
                    case "crisps":
                        doTransaction(1.5, "Crisps");
                        break;
                    case "soda":
                        doTransaction(0.8, "Soda");
                        break;
                    case "coke":
                        doTransaction(1.0, "Coke");
                        break;
                    default:
                        System.out.println("Invalid product");
                        break;
                }
            }
        } while (!input.equals("end"));
        System.out.printf("Change: %.2f", balance);
    }
}
