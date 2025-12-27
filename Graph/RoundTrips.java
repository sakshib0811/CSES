package Graph;

import java.io.*;
import java.util.*;

public class RoundTrips {

    static int start = -1, end = -1;

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ')
                if (c == -1)
                    return -1;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ')
                val = val * 10 + (c - '0');
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ')
                if (c == -1)
                    return -1;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = c - '0';
            while ((c = read()) > ' ')
                val = val * 10 + (c - '0');
            return val * sign;
        }

        String nextString() throws IOException {
            int c;
            while ((c = read()) <= ' ')
                if (c == -1)
                    return null;

            StringBuilder sb = new StringBuilder();
            sb.append((char) c);

            while ((c = read()) > ' ')
                sb.append((char) c);

            return sb.toString();
        }

    }

    public static boolean dfs(int node, boolean[] vis, int[] parent, List<List<Integer>> adj) {

        vis[node] = true;
        for (int child : adj.get(node)) {
            if (child == parent[node])
                continue;
            if (vis[child]) {
                start = child;
                end = node;
                return true;
            } else {
                parent[child] = node;
                if (dfs(child, vis, parent, adj))
                    return true;
            }
        }
        return false;
    }

    public static void print(int[] parent) {
        List<Integer> ans = new ArrayList<>();
        PrintWriter out = new PrintWriter(System.out);
        ans.add(start);
        for (int i = end; i != start; i = parent[i]) {
            ans.add(i);
        }
        ans.add(start);
        Collections.reverse(ans);
        out.println(ans.size());
        for (int i : ans)
            out.print(i + " ");
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int m = fs.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int node1 = fs.nextInt();
            int node2 = fs.nextInt();
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        boolean[] vis = new boolean[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                parent[i] = -1;
                if (dfs(i, vis, parent, adj)) {
                    print(parent);
                    return;
                }
            }
        }
        out.println("IMPOSSIBLE");
        out.flush();
    }
}
