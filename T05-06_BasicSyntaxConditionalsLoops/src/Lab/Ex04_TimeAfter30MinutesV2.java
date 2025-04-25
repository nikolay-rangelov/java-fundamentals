package Lab;

import java.util.Scanner;

public class Ex04_TimeAfter30MinutesV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());

        minutes += 30;

        if (minutes >= 60) {
            hours++;
            minutes-= 60;
        }

        if (hours > 23) {
            hours = 0;
        }

        System.out.printf("%d:%02d", hours, minutes);
    }
}
