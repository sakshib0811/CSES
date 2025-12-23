package Graph;

import java.io.*;
import java.util.*;

public class Labyrinth {

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

    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int m = fs.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(fs.nextString());
        }
        char[][] grid = new char[n][m];
        int[][] vis = new int[n][m];
        int ai = -1, ae = -1, bi = -1, be = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = arr.get(i).charAt(j);
                if (grid[i][j] == 'A') {
                    ai = i;
                    ae = j;
                }
                if (grid[i][j] == 'B') {
                    bi = i;
                    be = j;
                }
            }
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(ai, ae));
        vis[ai][ae] = 1;
        char[] dir = { 'U', 'D', 'L', 'R' };
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        Pair[][] parent = new Pair[n][m];
        char[][] move = new char[n][m];
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.start, y = p.end;
            if (x == bi && y == be) {
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] == '#' || vis[nx][ny] == 1)
                    continue;

                vis[nx][ny] = 1;
                parent[nx][ny] = new Pair(x, y);
                move[nx][ny] = dir[d];
                q.add(new Pair(nx, ny));

            }
        }

        if (vis[bi][be] == 0) {
            out.println("NO");
        } else {
            StringBuilder bf = new StringBuilder();
            int x = bi, y = be;
            while (!(x == ai && y == ae)) {
                bf.append(move[x][y]);
                Pair p = parent[x][y];
                x = p.start;
                y = p.end;
            }
            bf.reverse();
            out.println("YES");
            out.println(bf.length());
            out.println(bf.toString());
        }
        out.flush();

    }

}
