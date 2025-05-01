package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex06_StrongNumber {
    public static int factorial(int num) {
        int factorial = 1;
        if (num != 0) {
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
            }
        }
        return factorial;
    }

    public static boolean isStrong(int num) {
        boolean isStrong = false;
        int initialNum = num;
        int factorialSum = 0;
        while(num != 0) {
            int digit = num % 10;
            num /= 10;
            factorialSum += factorial(digit);
        }
        if (factorialSum == initialNum) {
            isStrong = true;
        }
        return isStrong;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int num = Integer.parseInt(sc.nextLine());
        if (isStrong(num)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
