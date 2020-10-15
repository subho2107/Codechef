import java.io.*;
import java.util.*;

class ReplaceForX {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), X = Integer.parseInt(inp[1]), p = Integer.parseInt(inp[2]), k = Integer.parseInt(inp[3]);
            inp = buffer.readLine().split(" ");
            int[] arr = new int[n];
            boolean check = false;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                if (arr[pos] == X)
                    check = true;
            }
            Arrays.sort(arr);
            if (arr[p - 1] == X)
                sb.append("0\n");
            else {
                int ans = 0;
                if (!check) {
                    arr[k - 1] = X;
                    ans++;
                }
                Arrays.sort(arr);
                if (arr[p - 1] == X) {
                    sb.append(ans).append("\n");
                    continue;
                } else if (arr[k - 1] == X && k != p) {
                    sb.append("-1\n");
                    continue;
                }
                int pos = -1;check = false;
                for (int i = 0; i < n; i++) {
                    if (i!=(k-1) && arr[i] == X && ((p-1 > i && p <= k) || (p >= k && i > p-1))) {
                        if (pos == -1)
                            pos = i;
                        else if (Math.abs(p - (pos + 1)) > Math.abs(p - (i + 1)))
                            pos = i;
                        check = true;
                    }
                }
                if (!check)
                    sb.append("-1\n");
                else {
                    ans += Math.abs(p - (pos + 1));
                    sb.append(ans + "\n");
                }
            }

        }
        System.out.println(sb);
    }
}
