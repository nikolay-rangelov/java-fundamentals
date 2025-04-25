package Lab;

import java.util.Scanner;

public class Ex07_TheatrePromotion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine().toLowerCase();
        int age = Integer.parseInt(sc.nextLine());
        int price = 0;
        switch (day) {
            case "weekday":
                if (0 <= age && age <= 18) {
                    price = 12;
                } else if (18 < age && age <= 64) {
                    price = 18;
                } else if (64 < age && age <= 122) {
                    price = 12;
                } else {
                    price = -1;
                }
                break;
            case "weekend":
                if (0 <= age && age <= 18) {
                    price = 15;
                } else if (18 < age && age <= 64) {
                    price = 20;
                } else if (64 < age && age <= 122) {
                    price = 15;
                } else {
                    price = -1;
                }
                break;
            case "holiday":
                if (0 <= age && age <= 18) {
                    price = 5;
                } else if (18 < age && age <= 64) {
                    price = 12;
                } else if (64 < age && age <= 122) {
                    price = 10;
                } else {
                    price = -1;
                }
                break;
        }

        if (price == -1) {
            System.out.println("Error!");
        } else {
            System.out.printf("%d$", price);
        }
    }
}
