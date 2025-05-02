package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        double balance = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        double lightsaberPrice = Double.parseDouble(sc.nextLine());
        double robePrice = Double.parseDouble(sc.nextLine());
        double beltPrice = Double.parseDouble(sc.nextLine());

        int lightsabers = (int) Math.ceil(1.1 * students);
        int belts = students - (int) (students / 6);

        double amountNeeded = lightsabers * lightsaberPrice + students * robePrice + belts * beltPrice;

        if (balance >= amountNeeded) {
            System.out.printf("The money is enough - it would cost %.2flv.", amountNeeded);
        } else {
            System.out.printf( "George Lucas will need %.2flv more.", amountNeeded - balance);
        }
    }
}
