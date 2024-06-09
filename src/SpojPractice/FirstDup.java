package SpojPractice;

import java.util.Scanner;

public class FirstDup {
    public static int firstDuplicate(int[] arr) {
        int[] count = new int[arr.length + 1];
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
            if (count[arr[i]] == 2 && i < minIndex) {
                minIndex = i;
            }
        }
        if (minIndex == Integer.MAX_VALUE) {
            return -1;
        }
        return arr[minIndex];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scanner.nextInt();
            }
            int result = firstDuplicate(arr);
            System.out.println("#" + i + " " + result);
        }
        scanner.close();
    }
}
