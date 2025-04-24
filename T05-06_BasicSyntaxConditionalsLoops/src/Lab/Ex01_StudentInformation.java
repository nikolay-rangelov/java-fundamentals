package Lab;

import java.util.Scanner;

public class Ex01_StudentInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        double avrGrade = Double.parseDouble(sc.nextLine());

        String output = String.format("Name: %s, Age: %d, Grade: %.2f", name, age, avrGrade);

        System.out.println(output);
    }
}
