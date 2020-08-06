import java.io.*;
import java.util.*;

public class ChefAndSteps{
    public static void main(String args[]) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bu.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String [] inp = bu.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = bu.readLine().split(" ");
            for (int pos = 0; pos < n; pos++) {
                int num = Integer.parseInt(inp[pos]);
                if (num % k == 0)
                    sb.append(1);
                else
                    sb.append(0);
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}
