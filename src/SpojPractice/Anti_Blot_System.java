package SpojPractice;

import java.util.Scanner;

public class Anti_Blot_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int tc = 0; tc < T; tc++) {
            scanner.nextLine();
            String[] parts = scanner.nextLine().split("\\s+");

            // mảng lưu trữ chuyển đổi sang integer
            int[] nums = new int[5];
            for (int i = 0; i < 5; i++) {
                nums[i] = convertStringToInt(parts[i]);
            }

            int n1 = nums[0];
            int n2 = nums[2];

            if (n1 < 0) nums[0] = nums[4] - nums[2];
            else if (n2 < 0) nums[2] = nums[4] - nums[0];
            else nums[4] = nums[0] + nums[2];

            System.out.println(nums[0] + " + " + nums[2] + " = " + nums[4]);
        }

    }
    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static int convertStringToInt(String str) {
        if (isNumeric(str)) {
            return Integer.parseInt(str);
        } else {
            return -1;
        }
    }
}
