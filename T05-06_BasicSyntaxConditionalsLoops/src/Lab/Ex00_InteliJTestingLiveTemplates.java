package Lab;

import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.in;

public class Ex00_InteliJTestingLiveTemplates {

    //psfi - public static final int
    public static final int costInt = 3;

    //psfs - public static final string
    public static final String constString = "This string is a constant and can not be changed.";


    //psvm || main - public static void main
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        // Live templates in InteliJ.
        // With examples.

        //fori - creates basic for loop
        for (int i = 0; i < 10; i++) {

        }

        // itar - Iterate elements of array
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }

        //mn - sets lesser value to a variable
        int minValue = Math.min(5, 6);

        //mx - sets greater value to a variable
        int maxValue = Math.max(5, 6);

        //ritar - iterate elements of arrray in reverse order
        for (int i = args.length - 1; i >= 0; i--) {
            String arg = args[i];
        }

        //sout || soutc
        System.out.println();

        //souf
        System.out.printf("");
    }
}
