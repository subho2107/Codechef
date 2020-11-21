import java.io.*;
import java.util.*;
// part of code taken from https://www.geeksforgeeks.org/number-nges-right/
class UnusualQueries {
    static int [] next;;
    static void fillNext(int[] next, int[] a, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (s.size() > 0) {
                int cur = s.peek();
                if (a[cur] < a[i]) {
                    next[cur] = i;
                    s.pop();
                } else
                    break;
            }
            s.push(i);
        }
        while (s.size() > 0) {
            int cur = s.peek();
            next[cur] = -1;
            s.pop();
        }
    }
    static int count(int[] dp, int l, int r) {
        int maxLength = 0;
        for (int i = r , j = r - l; i >= l && j >= 0; i--, j--) {
            if (next[i] == -1 || next[i] > r)
                dp[j] = 0;
            else {
                dp[j] = 1 + dp[next[i] - l];
                maxLength = Math.max(dp[j], maxLength);
            }
        }
        maxLength++;
        return maxLength;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]), s = Integer.parseInt(inp[2]);
        int[] height = new int[n];
        inp = buffer.readLine().split(" ");
        for (int i = 0; i < n; i++)
            height[i] = Integer.parseInt(inp[i]);
        int previousAns = 0;
        next = new int[n];
        fillNext(next, height, n);
        for (int i = 0; i < q; i++) {
            inp = buffer.readLine().split(" ");
            int l = Integer.parseInt(inp[0]), r = Integer.parseInt(inp[1]);
            l = (l + s * previousAns - 1) % n;
            r = (r + s * previousAns - 1) % n;
            if (l > r)
                l = l ^ r ^ (r = l);
            int[] dp = new int[r - l + 1];
//            count(Arrays.copyOfRange(height, l, r + 1), dp, r - l + 1);
            previousAns = count(dp, l, r);
            sb.append(previousAns).append("\n");
        }
        System.out.println(sb);
    }
}
