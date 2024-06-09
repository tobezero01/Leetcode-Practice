package SpojPractice;

import java.util.Scanner;

public class HeThongVienThong {


    //https://www.spoj.com/SVMCEXAM/problems/PROB06/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();

            char[][] map = new char[M][N];
            boolean[][] coverage = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == 'A' || map[i][j] == 'B' || map[i][j] == 'C') {
                        // Đánh dấu vùng phủ sóng của trạm lên ma trận coverage
                        for (int k = i - 3; k <= i + 3; k++) {
                            for (int l = j - 3; l <= j + 3; l++) {
                                if (k >= 0 && k < M && l >= 0 && l < N) {
                                    coverage[k][l] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        scanner.close();
    }
}
