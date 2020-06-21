import java.io.*;
import java.util.*;

class Max_Mex {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
            inp = buffer.readLine().split(" ");
            int [] arr = new int[n];
            int cntOfM = 0;
            HashSet<Integer>numsLessThanM = new HashSet<Integer>();
            for (int pos = 0; pos < n; pos++) {
                arr[pos] = Integer.parseInt(inp[pos]);
                numsLessThanM.add(arr[pos]);
                if (arr[pos]==m)cntOfM++;
            }
            if (numsLessThanM.size() < m-1)
            {
                sb.append("-1\n");
            }
            else
            {
                sb.append((n-cntOfM)+"\n");
            }

        }
        System.out.println(sb);
    }
}
