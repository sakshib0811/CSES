package DP;

import java.util.*;

public class ArrayDescription {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();

        int[][] dp = new int[n][m + 2]; //

        if (arr[0] == 0) {
            for (int i = 1; i <= m; i++)
                dp[0][i] = 1;
        } else {
            dp[0][arr[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i] != 0 && arr[i] != j)
                    continue;

                long val = dp[i - 1][j];
                if (j > 1)
                    val += dp[i - 1][j - 1];
                if (j < m)
                    val += dp[i - 1][j + 1];
                dp[i][j] = (int) (val % MOD);
            }
        }

        long ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[n - 1][i]) % MOD;
        }

        System.out.println(ans);
    }
}
