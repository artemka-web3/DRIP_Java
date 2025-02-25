package drip;

import java.util.Scanner;
import java.util.Arrays;
import java.util.SplittableRandom;


public class BrokenStringRepair {
    public static String fixString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }

        return new String(chars);
    }

    // Примеры использования
    public static void main(String[] args) {
        System.out.println(fixString("123456")); // ➞ "214365"
        System.out.println(fixString("hTsii  s aimex dpus rtni.g")); // ➞ "This is a mixed up string."
        System.out.println(fixString("badce")); // ➞ "abcde"
    }
}

