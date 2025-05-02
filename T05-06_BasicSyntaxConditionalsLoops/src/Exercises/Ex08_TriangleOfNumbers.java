package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex08_TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%d ", i);
            }
            System.out.printf("%n");
        }
    }
}
