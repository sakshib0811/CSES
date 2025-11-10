package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Subordinates {
    static final int MAX = 200005;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] subOrdinates = new int[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 2; i <= n; i++) {
            int boss = sc.nextInt();
            adj.get(boss).add(i);
        }
        sc.close();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int i : adj.get(node)) {
                q.add(i);
            }
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            int temp = ans.get(i);
            for (int j : adj.get(temp))
                subOrdinates[temp] += subOrdinates[j] + 1;
        }
        for (int i = 1; i <= n; i++)
            System.out.print(subOrdinates[i] + " ");

    }
}
