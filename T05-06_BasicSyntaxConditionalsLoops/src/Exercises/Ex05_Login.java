package Exercises;

import java.util.Scanner;

import static java.lang.System.in;

public class Ex05_Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        String username = sc.nextLine();
        String password = "";
        for (int i = username.length()-1; i >= 0; i--) {
            password = password + username.charAt(i);
        }
        String input = sc.nextLine();
        int tries = 0;
        boolean blocked = false;
        while (!input.equals(password)) {
            tries++;
            if(tries < 4) {
                System.out.println("Incorrect password. Try again.");
                input = sc.nextLine();
            } else {
                blocked = true;
                System.out.printf("User %s blocked!%n", username);
                break;
            }
        }

        if (!blocked) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
