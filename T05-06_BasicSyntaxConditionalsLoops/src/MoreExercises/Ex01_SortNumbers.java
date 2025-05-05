package MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Ex01_SortNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(sc.nextLine());
        }
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0; i--) {
            System.out.println(nums[i]);
        }
    }
}
