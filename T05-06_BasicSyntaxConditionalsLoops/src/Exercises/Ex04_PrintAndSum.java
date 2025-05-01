package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex04_PrintAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", i);
            sum += i;
        }
        System.out.printf("%nSum: %d", sum);
    }
}
