package SpojPractice;

import java.util.Scanner;

public class HeThongVienThong {


    //https://www.spoj.com/SVMCEXAM/problems/PROB06/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Số lượng test case
        for (int testCase = 1; testCase <= T; testCase++) {
            int M = scanner.nextInt(); // Số hàng của bản đồ
            int N = scanner.nextInt(); // Số cột của bản đồ

            // Đọc bản đồ và lưu trữ vào mảng 2 chiều
            char[][] map = new char[M][N];
            for (int i = 0; i < M; i++) {
                String line = scanner.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            // Biến đếm số lượng ô không có dân cư và không nằm trong phạm vi phủ sóng của bất kỳ trạm nào
            int count = 0;

            // Duyệt qua từng ô trong bản đồ
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'X') { // Ô không có dân cư
                        // Kiểm tra xem ô đó có nằm trong phạm vi phủ sóng của bất kỳ trạm nào không
                        if (!isCovered(map, M, N, i, j)) {
                            count++;
                        }
                    }
                }
            }

            // In kết quả
            System.out.println("#" + testCase + " " + count);
        }

        scanner.close();
    }

    // Hàm kiểm tra xem ô (i, j) có nằm trong phạm vi phủ sóng của bất kỳ trạm nào không
    public static boolean isCovered(char[][] map, int M, int N, int i, int j) {
        // Kiểm tra ô trên
        if (i > 0 && map[i - 1][j] != 'X') {
            return true;
        }
        // Kiểm tra ô dưới
        if (i < M - 1 && map[i + 1][j] != 'X') {
            return true;
        }
        // Kiểm tra ô bên trái
        if (j > 0 && map[i][j - 1] != 'X') {
            return true;
        }
        // Kiểm tra ô bên phải
        if (j < N - 1 && map[i][j + 1] != 'X') {
            return true;
        }
        return false;
    }
}
