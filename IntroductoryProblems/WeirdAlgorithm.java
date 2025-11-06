package IntroductoryProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeirdAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.close();
        List<Long> ans = new ArrayList<>();
        ans.add(n);
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                ans.add(n);
            } else {
                n = (n * 3) + 1;
                ans.add(n);
            }
        }
        for (long num : ans) {
            System.out.print(num + " ");
        }
    }

}