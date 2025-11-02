package DP;

import java.util.Arrays;
import java.util.Scanner;

public class GridPaths1 {
    static final int MOD = 1000000007;

    private int solve(int[][] dp, char[][] grid, int idx, int idx1) {
        if (idx >= grid.length || idx1 >= grid[0].length)
            return 0;
        if (grid[idx][idx1] == '*')
            return 0;
        if (idx == grid.length - 1 && idx1 == grid[0].length - 1)
            return 1;
        if (dp[idx][idx1] != -1)
            return dp[idx][idx1];
        dp[idx][idx1] = (solve(dp, grid, idx + 1, idx1) + solve(dp, grid, idx, idx1 + 1)) % MOD;
        return dp[idx][idx1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }
        sc.close();
        int[][] dp = new int[n][n];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        GridPaths1 obj = new GridPaths1();
        System.out.println(obj.solve(dp, grid, 0, 0));

    }
}
