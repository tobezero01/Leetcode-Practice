package SpojPractice;

import java.util.Scanner;

public class QuanMa {
    static final int Q = 0;
    static final int K = 1;
    static final int P = 2;
    static final int Safe = 3;
    static final int Unsafe = 4;

    static int[][] board;
    static int ROW, COL;

    static int[] K_row = {-1, -2, 1, 2, -2, -1, 2, 1};
    static int[] K_col = {2, 1, 2, 1, -1, -2, -1, -2};

    static int[] Q_row = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] Q_col = {1, -1, -1, 0, 1, -1, 0, 1};
    static int Sum;

    static int checkK(int row, int col) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int r = row + K_row[i];
            int c = col + K_col[i];
            if (r <= ROW && r >= 0 && c <= COL && c >= 0) {
                if (board[r][c] == Safe) {
                    board[r][c] = Unsafe;
                    count++;
                }
            }
        }
        return count;
    }

    static void checkQ(int row, int col, int direct) {
        int r = row + Q_row[direct];
        int c = col + Q_col[direct];
        if (r <= ROW && r >= 0 && c <= COL && c >= 0) {
            if (board[r][c] == Safe) {
                board[r][c] = Unsafe;
                Sum--;
                checkQ(r, c, direct);
            } else if (board[r][c] == Unsafe) {
                checkQ(r, c, direct);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 0;
        while (true) {
            ROW = sc.nextInt();
            COL = sc.nextInt();
            if (ROW == 0 && COL == 0) break;
            tc++;
            Sum = ROW * COL;
            ROW--;
            COL--;

            board = new int[ROW + 1][COL + 1];
            for (int r = 0; r <= ROW; r++) {
                for (int c = 0; c <= COL; c++) {
                    board[r][c] = Safe;
                }
            }

            int[][] row = new int[2][100];
            int[][] col = new int[2][100];
            int[] num = new int[3];

            for (int i = 0; i < 3; i++) {
                num[i] = sc.nextInt();
                for (int j = 0; j < num[i]; j++) {
                    int r = sc.nextInt() - 1;
                    int c = sc.nextInt() - 1;
                    board[r][c] = i;
                    if (i != 2) {
                        row[i][j] = r;
                        col[i][j] = c;
                    }
                }
            }

            Sum -= num[Q] + num[K] + num[P];

            for (int j = 0; j < num[K]; j++) {
                Sum -= checkK(row[K][j], col[K][j]);
            }

            for (int j = 0; j < num[Q]; j++) {
                for (int i = 0; i < 8; i++) {
                    checkQ(row[Q][j], col[Q][j], i);
                }
            }

            System.out.println("Board " + tc + " has " + Sum + " safe squares.");
        }
        sc.close();
    }
}
