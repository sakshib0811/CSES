package DP;

import java.util.Scanner;

public class CoinCombination1 {
    static final int MOD = 1000000007;

    private int solve(int[] dp, int[] coins, int sum) {
        for (int i = 1; i <= sum; i++) {
            for (int j : coins) {
                if (i - j >= 0)
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        sc.nextLine();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        CoinCombination1 obj = new CoinCombination1();
        System.out.println(obj.solve(dp, coins, sum));
    }
}
