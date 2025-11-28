package SearchingAndSorting;

import java.io.*;
import java.util.*;

public class FerrisWheels {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(st.nextToken()));
        int l = 0, r = n - 1, ans = 0;
        Collections.sort(arr);
        while (l <= r) {
            ans++;
            if (arr.get(l) + arr.get(r) <= x) {
                l++;
                r--;
            } else
                r--;
        }
        System.out.println(ans);
    }
}