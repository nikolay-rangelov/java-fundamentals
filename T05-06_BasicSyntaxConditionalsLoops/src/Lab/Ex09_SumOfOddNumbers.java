package Lab;

import java.util.Scanner;

public class Ex09_SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int num = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(num);
            sum += num;
            num += 2;
        }
        System.out.println("Sum: " + sum);
    }
}
