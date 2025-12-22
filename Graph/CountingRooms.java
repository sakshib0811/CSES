// package Graph;

import java.io.*;
import java.util.ArrayList;

public class CountingRooms {

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

    public static void dfs(char[][] g, int[][] vis, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return;
        if (g[i][j] == '#')
            return;
        if (vis[i][j] == 1)
            return;
        vis[i][j] = 1;
        dfs(g, vis, i, j + 1, n, m);
        dfs(g, vis, i, j - 1, n, m);
        dfs(g, vis, i - 1, j, n, m);
        dfs(g, vis, i + 1, j, n, m);
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int m = fs.nextInt();
        char[][] grid = new char[n][m];
        int[][] vis = new int[n][m];
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(fs.nextString());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = arr.get(i).charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && vis[i][j] == 0) {
                    dfs(grid, vis, i, j, n, m);
                    ans++;
                }
            }
        }
        out.println(ans);
        out.flush();

    }

}
