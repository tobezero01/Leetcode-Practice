package SpojPractice;

import java.util.Scanner;

public class SoDep {
    public static int countSpecialValues(int number, int[] specialValues) {
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            for (int specialValue : specialValues) {
                if (digit == specialValue) {
                    count++;
                }
            }
            number /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] beautifulNumbers = new int[n];

            for (int j = 0; j < n; j++) {
                beautifulNumbers[j] = scanner.nextInt();
            }

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int count = 0;
            for (int k = x; k <= y; k++) {
                if (countSpecialValues(k,beautifulNumbers) >= m) {
                    count++;
                }
            }
            System.out.println("#" + i + " " + count);
        }


        scanner.close();
    }
}
