package Graph;

import java.io.*;
import java.util.*;

public class MessageRoute {
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

    public static void main(String[] args) throws IOException {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int m = fs.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int node1 = fs.nextInt();
            int node2 = fs.nextInt();
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        parent[1] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int child : adj.get(temp)) {
                if (parent[child] == -1) {
                    parent[child] = temp;
                    q.add(child);
                }
            }
        }
        if (parent[n] == -1) {
            out.println("IMPOSSIBLE");
            out.flush();
            return;
        }

        List<Integer> ans = new ArrayList<>();
        int temp = n;
        while (temp != 0) {
            ans.add(temp);
            temp = parent[temp];
        }
        Collections.reverse(ans);
        out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i) + " ");
        }
        out.println();
        out.flush();

    }
}
