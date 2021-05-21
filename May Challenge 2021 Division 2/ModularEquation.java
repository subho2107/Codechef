import java.io.*;
import java.util.*;

public class ModularEquation {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            int [] bCnt = new int[m+1];
            long ans = 0;
            for (int i = n; i >= 1; i--) {
                int mod = m%i;
                for (int j = mod; j <= Math.min(n, m); j+=i) {
                    ans += bCnt[j];
                }
                bCnt[mod]++;
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
    }
}
