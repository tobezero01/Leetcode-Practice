package SpojPractice;

import java.util.Scanner;

public class validSudoku {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//
//        for (int t = 1; t <= T; t++) {
//
//            char[][] board = new char[9][9];
//            for (int i = 0; i < 9; i++) {
//                board[i] = scanner.nextLine().toCharArray();
//
//            }
//            boolean isValid = isValidSudoku(board);
//            System.out.println("#" + t + " " + (isValid ? "1" : "0"));
//        }
//        scanner.close();
//    }
//
//    private static boolean isValidSudoku(char[][] board) {
//        boolean[][] rows = new boolean[9][9];
//        boolean[][] cols = new boolean[9][9];
//        boolean[][] boxes = new boolean[9][9];
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != '.') {
//                    int num = board[i][j] - '1';
//                    int boxIndex = (i / 3) * 3 + (j / 3);
//
//                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
//                        return false;
//                    }
//                    rows[i][num] = true;
//                    cols[j][num] = true;
//                    boxes[boxIndex][num] = true;
//                }
//            }
//        }
//
//        return true;
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống sau số test case

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            char[][] board = new char[9][9];
            for (int i = 0; i < 9; i++) {
                board[i] = scanner.nextLine().toCharArray();
            }
            System.out.printf("#%d %d%n", caseIndex, isValidSudoku(board) ? 1 : 0);
        }
        scanner.close();
    }

    private static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, 0, i, 8) || !isValid(board, 0, i, 8, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValid(board, i, j, i + 2, j + 2)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(char[][] board, int rowStart, int colStart, int rowEnd, int colEnd) {
        boolean[] seen = new boolean[9];
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }
        return true;
    }
}
