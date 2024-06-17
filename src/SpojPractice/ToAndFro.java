package SpojPractice;

import java.util.Scanner;

public class ToAndFro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Nhập số lượng cột
            int NUM_COL = scanner.nextInt();
            if (NUM_COL == 0) break;

            // Xâu đầu vào
            String str = scanner.next();

            // Tính độ dài của xâu
            int length = str.length();

            // Lưu ma trận
            char[][] Mat = new char[101][21];

            // Lưu toạ độ hàng và cột đang đứng
            int col = 0, row = 0;

            // biến thiên chỉ số cột: = 1 nếu đi từ trái sang phải
            // ngược lại = -1
            int delta = 1;

            // Duyệt xâu để chuyển xâu thành ma trận
            for (int i = 0; i < length; i++) {
                // Ban đầu là đi từ trái sang phải => chỉ số cột tăng
                Mat[row][col] = str.charAt(i);
                col += delta;

                // Khi đi đến cuối thì quay về trái
                if (col >= NUM_COL) {
                    Mat[row][col] = '\0';
                    row++;
                    Mat[row][col] = '\0';
                    delta = -1;
                    col += delta;
                } else if (col < 0) { // Khi đi đến đầu thì quay sang bên phải
                    row++;
                    delta = 1;
                    col += delta;
                }
            }

            // Tìm ra kết quả
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < NUM_COL; j++) {
                for (int i = 0; i < row; i++) {
                    result.append(Mat[i][j]);
                }
            }
            System.out.println(result);
        }
    }
}
