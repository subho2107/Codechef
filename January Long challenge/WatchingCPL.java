import java.io.*;
import java.util.*;

class WatchingCPL {
    //taken from https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
    static int findMin(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String[] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            long a = 0, b = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(inp[i]);
            Arrays.sort(arr);
            int cnt = 0;
            int pos = -1;
            for (int i = n - 1; i >= 0 && (cnt <= 1 || a < 2L * k); i--) {
                a += arr[i];
                pos = i;
                cnt++;
            }
            if (a >= 2L * k) {
                int[] temp = Arrays.copyOfRange(arr, pos, arr.length);
                int minDiff = findMin(temp, temp.length);
                long x = (a + minDiff) / 2;
                long y = a - x;
                if (x >= k && y >= k)
                    sb.append(cnt).append("\n");
                else {
                    long notK = Math.min(x, y);
                    for (int i = pos-1; i >=0 && notK < k ; i--) {
                        notK += arr[i];
                        cnt++;
                    }
                    if (notK >= k)
                        sb.append(cnt).append("\n");
                    else
                        sb.append("-1\n");
                }

            } else
                sb.append(-1 + "\n");
        }
        System.out.println(sb);
    }
}
