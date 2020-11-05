import java.io.*;
import java.util.*;

public class EmpireBusiness {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            int [] left = new int[n], right = new int[n];
            left[0] = arr[0];
            for (int i = 1; i < n; i++)
                left[i] = Math.min(left[i-1] + 1, arr[i]);
            right[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--)
                right[i] = Math.min(right[i+1]+1, arr[i]);
            for (int i = 0; i < n; i++)
                sb.append(Math.min(left[i], right[i])+" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
