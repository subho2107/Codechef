import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class AlienInvasion {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int p = Integer.parseInt(inp[0]), q = Integer.parseInt(inp[1]);
            String res = new BigDecimal(p).divide(new BigDecimal(q), 1001, RoundingMode.FLOOR).toString().split("\\.")[1].substring(0, n);
//            String res = num.split("\\.")[1].substring(0, Math.min(n, num.split("\\.")[1].length()));
            long sum = 0;
            for(char ch:res.toCharArray())
            {
                sum += Integer.parseInt(String.valueOf(ch));
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}
