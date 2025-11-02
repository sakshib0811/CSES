package DP;

import java.util.Scanner;

public class CoinCombinations2 {
    static final int MOD = 1000000007;

    private int solve(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i : coins) {
            for (int j = i; j <= sum; j++) {
                dp[j] = (dp[j] + dp[j - i]) % MOD;
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
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();
        sc.close();
        CoinCombinations2 obj = new CoinCombinations2();
        System.out.println(obj.solve(coins, sum));
    }
}