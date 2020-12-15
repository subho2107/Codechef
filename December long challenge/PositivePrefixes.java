import java.io.*;
import java.util.*;

public class PositivePrefixes {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            int[] arr = new int[n];
            if (n == k || k == n - 1) {
                for (int i = 0; i < n; i++) {
                    if (k == n || (k == n - 1 && i != 0))
                        sb.append(i + 1).append(" ");
                    else if (i == 0)
                        sb.append(-1).append(" ");
                }
                sb.append("\n");
                continue;
            }
            int cnt = 0, dup = k;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = -(i + 1);
            }
            for (int i = 0; i < n && dup > 0; i += 2) {
                arr[i] *= -1;
                dup--;
            }
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > 0) cnt++;
            }
            if (cnt != k) {
                if (cnt > k)
                    arr[0] *= -1;
                else {
                    for (int i = n - 1; i >= 0 && cnt != k; i--) {
                        if (arr[i] < 0) {
                            arr[i] *= -1;
                            cnt++;
                        }
                    }
                }
            }
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
// 1 2 3 -4 5 -6 7 8 -9 -10