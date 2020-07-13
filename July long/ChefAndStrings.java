import java.io.*;
import java.util.*;

public class ChefAndStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            long diff = 0;
            for (int pos = 0; pos < n - 1; pos++) {
                diff += Math.abs(Integer.parseInt(inp[pos]) - Integer.parseInt(inp[pos + 1])) - 1;
            }
            sb.append(diff + "\n");
        }
        System.out.println(sb);
    }
}
