package DP;

import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int amt = sc.nextInt();
        sc.nextLine();
        int[] price = new int[n], pages = new int[n];
        for (int i = 0; i < n; i++)
            price[i] = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++)
            pages[i] = sc.nextInt();
        sc.close();
        int[] dp = new int[amt + 1];
        for (int i = 0; i < n; i++) {
            for (int j = amt; j >= price[i]; j--) {
                dp[j] = Math.max(dp[j], pages[i] + dp[j - price[i]]);
            }
        }
        System.out.println(dp[amt]);
    }
}
