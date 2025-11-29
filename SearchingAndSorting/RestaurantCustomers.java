package SearchingAndSorting;

import java.io.*;
import java.util.*;

public class RestaurantCustomers {

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
        FastScanner fc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fc.nextInt();
        ArrayList<Integer> aTime = new ArrayList<>();
        ArrayList<Integer> eTime = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aTime.add(fc.nextInt());
            eTime.add(fc.nextInt());
        }
        Collections.sort(aTime);
        Collections.sort(eTime);
        int ans = Integer.MIN_VALUE, count = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (aTime.get(i) <= eTime.get(j)) {
                count++;
                ans = Math.max(ans, count);
                i++;
            } else {
                j++;
                count--;
            }
        }
        out.println(ans);
        out.flush();

    }
}
