package SpojPractice;

import java.util.Arrays;
import java.util.Scanner;

public class XayThap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Số lượng test case
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int M1 = scanner.nextInt();
            int M2 = scanner.nextInt();

            int[] weights = new int[N];

            // Đọc cân nặng của các viên gạch
            for (int i = 0; i < N; i++) {
                weights[i] = scanner.nextInt();
            }
            // Sắp xếp mảng cân nặng theo thứ tự không giảm
            Arrays.sort(weights);

            int costM1 = 0 , costM2 = 0;
            int index = N-1;
            if(M1 >= M2) {
                for (int i = 1; i <=M2; i++) {
                    costM1 += i * weights[index--];
                    costM2 += i * weights[index--];
                }
                for (int i = M2+1; i <= M1; i++) {
                    costM1+= i * weights[index--];
                }
            }
            else {
                for (int i = 1; i <=M1; i++) {
                    costM1 += i * weights[index--];
                    costM2 += i * weights[index--];
                }
                for (int i = M1+1; i <= M2; i++) {
                    costM2+= i * weights[index--];
                }
            }

            int totalCost = costM1 + costM2;

            // In kết quả
            System.out.println("#" + testCase + " " + totalCost);
        }

        scanner.close();
    }


}
