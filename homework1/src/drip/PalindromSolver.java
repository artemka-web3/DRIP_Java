package drip;

class PalindromSolver {
    public static boolean isPalindromeDescendant(int number) {
        // Проверяем, является ли исходное число палиндромом
        if (isPalindrome(number)) {
            return true;
        }

        // Пока длина числа больше 1, генерируем потомков
        while (number >= 10) {
            number = getDescendant(number);
            if (isPalindrome(number)) {
                return true;
            }
        }

        // Если ни один потомок не является палиндромом
        return false;
    }

    // Вспомогательная функция для проверки, является ли число палиндромом
    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Вспомогательная функция для генерации потомка
    private static int getDescendant(int number) {
        String str = Integer.toString(number);
        StringBuilder descendant = new StringBuilder();

        // Суммируем каждую пару соседних цифр
        for (int i = 0; i < str.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(str.charAt(i));
            int digit2 = Character.getNumericValue(str.charAt(i + 1));
            descendant.append(digit1 + digit2);
        }

        // Если длина числа нечетная, добавляем последнюю цифру
        if (str.length() % 2 != 0) {
            descendant.append(str.charAt(str.length() - 1));
        }

        return Integer.parseInt(descendant.toString());
    }

    // Примеры использования
    public static void main(String[] args) {
        System.out.println(isPalindromeDescendant(11211230)); // true
        System.out.println(isPalindromeDescendant(13001120)); // true
        System.out.println(isPalindromeDescendant(23336014)); // true
        System.out.println(isPalindromeDescendant(11)); // true
        System.out.println(isPalindromeDescendant(123)); // false
    }
}
