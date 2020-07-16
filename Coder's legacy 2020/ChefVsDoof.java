import java.io.*;
import java.util.*;

public class ChefVsDoof {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            boolean check = true;
            for (int pos = 0; pos < n; pos++) {
                int num = Integer.parseInt(inp[pos]);
                if (num%2==0)
                {
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
