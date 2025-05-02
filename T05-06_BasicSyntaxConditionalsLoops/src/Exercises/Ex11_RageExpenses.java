package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex11_RageExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int lostGameCount = Integer.parseInt(sc.nextLine());
        double headsetPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());
        double keyboardPrice = Double.parseDouble(sc.nextLine());
        double displayPrice = Double.parseDouble(sc.nextLine());

        int trHeadsets = lostGameCount / 2;
        int trMouses = lostGameCount / 3;
        int trKeyboards = lostGameCount / 6;
        int trDisplays = lostGameCount / 12;

        double amount = trHeadsets * headsetPrice + trMouses * mousePrice + trKeyboards * keyboardPrice + trDisplays * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", amount);
    }
}
