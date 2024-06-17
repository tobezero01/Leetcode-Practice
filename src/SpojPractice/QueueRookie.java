package SpojPractice;

import java.util.Arrays;
import java.util.Scanner;

public class QueueRookie {
    public static int[] countingSort(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int range = max - min + 1;
        int[] count = new int[range];
        for (int i = 0; i < n; i++) {
            count[nums[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                nums[index++] = i + min;
                count[i]--;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            int[] finalPos = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if(arr[i] >= max) max = arr[i];
            }
            int[] highIndex = new int[max+1];
            for (int i = 0; i <=max ; i++) {
                highIndex[i] = 0;
            }
            for (int i = 0; i < N; i++) {
                highIndex[arr[i]] = scanner.nextInt();
            }

            arr = countingSort(arr);

            for (int i = 0; i < N; i++) {
                int cnt = highIndex[arr[i]];
                for (int j = 0; j < N; j++) {
                    if (cnt == 0 && finalPos[j] == 0) {
                        finalPos[j] = arr[i];
                        break;
                    }
                    if (finalPos[j] == 0) {
                        cnt--;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.print(finalPos[i] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

}
