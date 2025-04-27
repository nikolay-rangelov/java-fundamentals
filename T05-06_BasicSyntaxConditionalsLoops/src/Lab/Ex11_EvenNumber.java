package Lab;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Scanner;

public class Ex11_EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Math.abs(Integer.parseInt(sc.nextLine()));
        while (num % 2 == 1) {
            System.out.println("Please write an even number.");
            num = Math.abs(Integer.parseInt(sc.nextLine()));
        }

        System.out.printf("The number is: %d%n", num);
    }
}
