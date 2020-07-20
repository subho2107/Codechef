import java.io.*;
import java.util.*;

public class ORthodoxDistinction {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            long[]arr = new long[n];
            String [] temp = buffer.readLine().split(" ");
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Long.parseLong(temp[pos]);
            }
            Set<Long> res = new HashSet<>(), cur = new HashSet<>(), cur2;
            for (long i: arr) {
                cur2 = new HashSet<>();
                cur2.add(i);
                for (Long j: cur) cur2.add(i|j);
                res.addAll(cur = cur2);
            }
            long tot = (n*(n+1))/2;
            if (res.size() == tot)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
