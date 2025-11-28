package SearchingAndSorting;

import java.io.*;
import java.util.*;

public class Apartments {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> applicant = new ArrayList<>();
        ArrayList<Integer> appartment = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++)
            applicant.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++)
            appartment.add(Integer.parseInt(st.nextToken()));

        // bf.close(); // Don't close bufferedReder as
        // it will also close System.in, which can break further input reading or other
        // components in some IDE
        // Best for CP

        Collections.sort(applicant);
        Collections.sort(appartment);
        int i = 0, j = 0, ans = 0;
        while (i < n && j < m) {
            if (applicant.get(i) > appartment.get(j) + k)
                j++;
            else if (applicant.get(i) < appartment.get(j) - k)
                i++;
            else {
                i++;
                j++;
                ans++;
            }
        }
        System.out.println(ans);

    }

}