import java.io.*;
import java.util.*;

class BowlingStrategy {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]), l = Integer.parseInt(inp[2]);
            int []arr = new int[n];
            int [] freq = new int[k+1];
            boolean check = true;
            for (int pos = 0, num = 1; pos < n; pos++, num++) {
                if (num > k)
                    num = 1;
                arr[pos] = num;
                if (freq[arr[pos]] == l){
                    check = false;
                    break;
                }
                freq[arr[pos]]++;
            }
            for (int pos = 0; pos < n - 1; pos++) {
                if (arr[pos] == arr[pos+1]){
                    check = false;
                    break;
                }
            }
            if (check){
                for (int i : arr) {
                    sb.append(i+" ");
                }
                sb.append("\n");
            }
            else
                sb.append("-1\n");
        }
        System.out.print(sb);
    }
}
