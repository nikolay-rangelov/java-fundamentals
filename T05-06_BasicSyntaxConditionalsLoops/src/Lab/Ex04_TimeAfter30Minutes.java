package Lab;

import java.util.Scanner;

public class Ex04_TimeAfter30Minutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hoursNow = Integer.parseInt(sc.nextLine());
        int minutesNow = Integer.parseInt(sc.nextLine());

        int sum = hoursNow * 60 + minutesNow + 30;

        int hoursAfter = sum / 60;
        int minutesAfter = sum % 60;

        if (hoursAfter > 23) {
            hoursAfter = 0;
        }

        System.out.printf("%d:%02d", hoursAfter, minutesAfter);
    }
}
