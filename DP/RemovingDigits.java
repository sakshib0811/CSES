package DP;

import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {

    private int solve(int[] dp, int n) {
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                int rem = temp % 10;
                temp = temp / 10;
                if (rem > 0)
                    dp[i] = Math.min(dp[i], dp[i - rem] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        RemovingDigits obj = new RemovingDigits();
        System.out.println(obj.solve(dp, n));
    }
}
