package SpojPractice;

import java.util.Scanner;
//https://www.spoj.com/SVMCEXAM/problems/PAIRS1E/
public class CountThePairs {

    public static int abs(int n) {
        return n >= 0 ? n : -n;
    }
    public static int countPairsWithDifferenceK(int[] nums, int N, int K) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (abs(nums[i] - nums[j]) == K) {
                    count++;
                }
            }
        }
        return count;
//
//        boolean[] seen = new boolean[10001]; // Mảng để đánh dấu các số đã xuất hiện
//        int count = 0;
//
//        for (int i = 0; i < N; i++) {
//            int num = nums[i];
//            if (num - K >= 0 && seen[num - K]) {
//                count++;
//            }
//            if (num + K <= 10000 && seen[num + K]) {
//                count++;
//            }
//            seen[num] = true;
//        }
//
//        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] nums = new int[N]; // Mảng chứa các số

            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }

            int result = countPairsWithDifferenceK(nums, N, K);
            System.out.println(result);
        }
        scanner.close();
    }
}
