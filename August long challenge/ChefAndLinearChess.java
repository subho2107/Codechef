import java.io.*;
import java.util.*;

public class ChefAndLinearChess {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            boolean check = false;
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                if (k%arr[pos]==0)check = true;
            }
            if (!check)
                sb.append("-1\n");
            else {
                int minSteps = Integer.MAX_VALUE, val = 0;
                for (int pos = 0; pos < n; pos++) {
                    if (k%arr[pos]==0 && k/arr[pos]<minSteps){
                        minSteps = k/arr[pos];
                        val = arr[pos];
                    }
                }
                sb.append(val+"\n");
            }



        }
        System.out.println(sb);
    }
}
