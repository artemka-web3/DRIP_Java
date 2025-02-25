package drip;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class NestedArray {
    public static boolean isNestable(int [] a1, int[] a2) {
        int a1_min = Arrays.stream(a1).min().getAsInt();
        int a2_min = Arrays.stream(a2).min().getAsInt();

        int a1_max = Arrays.stream(a1).max().getAsInt();
        int a2_max = Arrays.stream(a2).max().getAsInt();

        int [] result = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, result, 0, a1.length);
        System.arraycopy(a2,0,result,a1.length,a2.length);

        System.out.println("Объединенный массив:");
        for (int i : result) {
            System.out.print(i + " ");
        }

        if (a1_min > a2_min && a1_max < a2_max) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числа через пробел для a1: ");
        String input_a1 = scanner.nextLine();
        String[] strNumbers_a1 = input_a1.split(" ");
        int [] numbers_a1 = new int[strNumbers_a1.length];
        for (int i = 0; i < strNumbers_a1.length; i++) {
            numbers_a1[i] = Integer.parseInt(strNumbers_a1[i]);
        }
        System.out.println("Введите числа через пробел для a2: ");
        String input_a2 = scanner.nextLine();
        String[] strNumbers_a2 = input_a2.split(" ");
        int [] numbers_a2 = new int[strNumbers_a2.length];
        for (int i = 0; i < strNumbers_a2.length; i++) {
            numbers_a2[i] = Integer.parseInt(strNumbers_a2[i]);
        }

        System.out.println(isNestable(numbers_a1, numbers_a2));


    }
}
