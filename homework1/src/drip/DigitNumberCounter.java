package drip;

import java.time.LocalTime;
import java.util.Scanner;

public class DigitNumberCounter {
    public static int countDigits(int number) {
        int numbers_counter = 0;
        do {
            number /= 10;
            numbers_counter++;
        } while (number > 0);
        return numbers_counter;
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int input = scanner.nextInt();
        System.out.println(countDigits(input));
    }
}
