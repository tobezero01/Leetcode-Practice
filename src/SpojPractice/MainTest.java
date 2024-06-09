package SpojPractice;

import java.util.Scanner;

public class MainTest {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1;
        int r = x;
        int mid = -1;
        while(l <= r) {
            mid = l+ (r - l) / 2;
            if((long)mid*mid > (long)x)
                r = mid-1;
            else if (mid * mid == x)
                return mid;
            else l = mid+1;
        }
        return r;
    }


    //   Số chính phương
    public static void chinh_phuong() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String s = "#" + (i+1);
            boolean check = false;

            for (int j = mySqrt(a); j <= mySqrt(b) ; j++) {
                int square = j*j;
                if (square >= a && square <= b) {
                    s+=" " +square;
                    check = true;
                }
            }
            if(!check) s = "NO NUMBER";
            System.out.println(s);
        }

    }




    //ADDREV - Adding Reversed Numbers
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    public static void addReverseNumber() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int reversedNum1 = reverseNumber(num1);
            int reversedNum2 = reverseNumber(num2);
            int sum = reversedNum1 + reversedNum2;
            int reversedSum = reverseNumber(sum);
            System.out.println(reversedSum);
        }
    }


    public static void Divisibility() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int count = n / x ;
            for (int j = 0; j <= count; j++) {
                int number = j * x;
                if (number % y != 0) {
                    System.out.print(number + " ");
                }
            }
        }
    }



    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void nen1(int n) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            while (N >= 10) {
                N = sumOfDigits(N);
            }
            System.out.println("#" + t + " " + N);
        }
    }

    public static void main(String[] args) {
        //addReverseNumber();
        //chinh_phuong();

    }
}
