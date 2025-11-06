package IntroductoryProblems;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n - 1];
        long currSum = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextLong();
            currSum += arr[i];
        }
        sc.close();
        long totalSum = (long) n * (n + 1) / 2;
        System.out.println(totalSum - currSum);

    }
}
