package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoin {
    private int solve(int[] dp, int[] coins, int sum) {
        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[sum] > sum ? -1 : dp[sum];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        scanner.nextLine();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = scanner.nextInt();
        scanner.close();
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, sum + 1);
        dp[0] = 0;
        MinimizingCoin obj = new MinimizingCoin();
        int ans = obj.solve(dp, coins, sum);
        System.out.println(ans);

    }
}
