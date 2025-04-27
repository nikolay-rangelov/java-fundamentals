package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex01_Ages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int age = Integer.parseInt(sc.nextLine());
        if (0 <= age && age <= 2) {
            System.out.println("baby");
        } else if (3 <= age && age <= 13) {
            System.out.println("child");
        } else if (14 <= age && age <= 19) {
            System.out.println("teenager");
        } else if (20 <= age && age <= 65) {
            System.out.println("adult");
        } else if (66 <= age) {
            System.out.println("elder");
        }
    }
}
