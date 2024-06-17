package SpojPractice;

import java.util.Scanner;

// find string
public class FNDSTR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = 10;
        scanner.nextLine();

        for (int t = 1; t <= T; t++) {
            int testCaseNumber = scanner.nextInt();
            scanner.nextLine();
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            int n = s1.length();
            int count = 0;
            for (int i = 0; i < s2.length(); i++) {
                for (int j = 0; j < s2.length()-n; j++) {
                    String s = s2.substring(j,j+n);
                    if(s.equals(s1)) count++;
                }
            }
            System.out.println("#" + testCaseNumber + " " + count);
        }
    }

}
