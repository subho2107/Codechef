import java.io.*;
import java.util.*;

public class ChefAndWork {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            boolean check = true;
            for (int pos = 0; pos < n; pos++) {
                arr[n-pos-1] = Integer.parseInt(inp[pos]);
                if (arr[n-pos-1]>k){
                    check = false;
                    break;
                }
            }
            if (!check){
                sb.append("-1\n");
            }
            else {
                int cnt = 0, sum = 0;
                for (int pos = 0; pos < n; pos++) {
                    if (sum+arr[pos]> k){
                        sum = 0;
                        cnt++;
                    }
                    sum+=arr[pos];
                }
                sb.append((cnt+1)+"\n");
            }
        }
        System.out.println(sb);
    }
}
