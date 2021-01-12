import java.io.*;
import java.util.*;

public class ChefAndDivision3 {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]), d = Integer.parseInt(inp[2]);
            inp = buffer.readLine().split(" ");
            long sum = 0;
            long ans;
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(inp[i]);
            }
            ans = Math.min(sum/k, d);
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
