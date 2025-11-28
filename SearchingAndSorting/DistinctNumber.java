package SearchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumber {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] data = bf.readLine().split(" ");
        int[] arr = new int[n];
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(data[i]);
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }
        bf.close();
        System.out.println(mpp.size());
    }
}
