package SearchingAndSorting;

import java.io.*;
import java.util.*;

public class SumOfTwoValues {

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

    public static void main(String[] args) throws IOException {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int sum = fs.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(fs.nextInt());
        ArrayList<Integer> arrTemp = new ArrayList<>(arr);
        Collections.sort(arrTemp);
        int i = 0, j = n - 1, idx1 = -1, idx2 = -1;
        while (i < j) {
            int a = arrTemp.get(i), b = arrTemp.get(j);
            if (a + b == sum) {
                idx1 = a;
                idx2 = b;
                break;
            } else if (a + b > sum)
                j--;
            else
                i++;
        }
        if (idx1 == -1 && idx2 == -1)
            out.println("IMPOSSIBLE");
        else {
            int ansi = -1, ansj = -1;
            for (int k = 0; k < arr.size(); k++) {
                if (arr.get(k) == idx1 && ansi == -1)
                    ansi = k + 1;
                else if (arr.get(k) == idx2 && ansj == -1)
                    ansj = k + 1;
            }
            out.println(ansi + " " + ansj);
        }
        out.flush();

    }
}
