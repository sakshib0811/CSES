package Graph;

import java.io.*;
import java.util.*;

public class BuildingRoads {
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

    public static void dfs(int i, boolean[] vis, List<List<Integer>> adj) {
        vis[i] = true;
        for (int child : adj.get(i)) {
            if (!vis[child]) {
                dfs(child, vis, adj);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int m = fs.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int node1 = fs.nextInt() - 1;
            int node2 = fs.nextInt() - 1;
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
                dfs(i, vis, adj);
            }
        }
        out.println(ans.size() - 1);
        for (int i = 0; i < ans.size() - 1; i++) {
            out.println((ans.get(i) + 1) + " " + (ans.get(i + 1) + 1));
        }

        out.flush();
    }
}
