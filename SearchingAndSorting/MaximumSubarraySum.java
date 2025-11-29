package SearchingAndSorting;

import java.io.*;
import java.util.*;

public class MaximumSubarraySum {

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
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(fs.nextInt());
        Long curSum = (long) 0, ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curSum += arr.get(i);
            ans = Math.max(curSum, ans);
            if (curSum < 0) {
                curSum = (long) 0;
            }
        }
        out.println(ans);
        out.flush();
    }
}
