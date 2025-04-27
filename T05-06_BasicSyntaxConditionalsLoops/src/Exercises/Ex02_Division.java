package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex02_Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int num = Integer.parseInt(sc.nextLine());

        if (num % 10 == 0) {
            System.out.println("The number is divisible by 10");
        } else if (num % 7 == 0) {
            System.out.println("The number is divisible by 7");
        } else if (num % 6 == 0) {
            System.out.println("The number is divisible by 6");
        } else if (num % 3 == 0) {
            System.out.println("The number is divisible by 3");
        } else if (num % 2 == 0) {
            System.out.println("The number is divisible by 2");
        } else {
            System.out.println("Not divisible");
        }
    }
}
