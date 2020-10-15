import java.io.*;
import java.util.*;

public class ChefAndEasyQueries {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine().trim());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
            }
            long sum = 0;
            int day = 1;
            boolean check = false;
            for (;day<=n; day++){
                sum+=arr[day-1]-k;
                if(sum < 0) {
                    check = true;
                    break;
                }
            }
            if (check)
                sb.append(day+"\n");
            else{
                long ans = n+(sum/k)+1;
                sb.append(ans+"\n");
            }
        }
        System.out.println(sb);
    }
}
