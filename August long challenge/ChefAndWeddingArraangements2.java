import java.io.*;
import java.util.*;

public class ChefAndWeddingArraangements2 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), tableCost = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n+1];
            for (int pos = 1; pos <= n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos-1]);
            }
            int [] dp = new int[n+1];
            HashMap<Integer, Integer>famFreq = new HashMap<>();
            for (int pos = 1; pos <= n ; pos++) {
                dp[pos] = dp[pos-1]+tableCost;
                int disp = 0;
                famFreq.clear();
                for (int pos2 = pos; pos2 >= 1 ; pos2--) {
                    famFreq.put(arr[pos2], famFreq.getOrDefault(arr[pos2], 0)+1);
                    if (famFreq.get(arr[pos2])==2)
                        disp+=2;
                    else if (famFreq.get(arr[pos2])>2)
                        disp++;
                    dp[pos] = Math.min(dp[pos], disp+dp[pos2-1]+tableCost);
                }
            }
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}
