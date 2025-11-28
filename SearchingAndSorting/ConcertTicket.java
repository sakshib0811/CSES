package SearchingAndSorting;

import java.io.*;
import java.util.*;

public class ConcertTicket {

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
        int m = fs.nextInt();
        TreeMap<Integer, Integer> mpp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int ticket = fs.nextInt();
            mpp.put(ticket, mpp.getOrDefault(ticket, 0) + 1);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int customer = fs.nextInt();
            Integer customerTicket = mpp.floorKey(customer);
            if (customerTicket == null)
                ans.append("-1\n");
            else {
                ans.append(customerTicket).append("\n");
                int key = mpp.get(customerTicket);
                if (key == 1)
                    mpp.remove(customerTicket);
                else
                    mpp.put(customerTicket, key - 1);
            }
        }
        out.println(ans);
        out.flush();
    }
}
