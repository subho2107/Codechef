import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Alien_Invasion {
    public static boolean isValid(double time, int[] arr, int d) {
        double currTime = 0;
        for (int pos = 0; pos < arr.length; pos++) {
            if (currTime < arr[pos]) {
                currTime = arr[pos] + time;
            } else if (currTime <= arr[pos] + d) {
                currTime += time;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), d = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            Arrays.sort(arr);
            double lo = 0, hi = 1e18, mid = 0;
            for (int i = 0; i < 100; i++) {
                mid = ((lo + hi) / 2.0);
                if (isValid(mid, arr, d))
                    lo = mid;
                else
                    hi = mid;
            }
            String ans = String.format("%.6f", mid);
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
