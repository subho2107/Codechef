import java.io.*;
import java.util.*;

public class SpaceArrays {
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
            Arrays.sort(arr);
            boolean check = true;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > i+1){
                    check = false;
                    break;
                }
                sum += i+1-arr[i];
            }
            if (sum % 2 == 1 && check)
                sb.append("First\n");
            else
                sb.append("Second\n");
        }
        System.out.println(sb);
    }
}
