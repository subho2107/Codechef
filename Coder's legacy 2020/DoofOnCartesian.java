import java.io.*;
import java.util.*;

class DoofOnCartesian {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String [] inp = buffer.readLine().split(" ");
            long [] points = new long[n];
            for (int pos = 0; pos < n; pos++) {
                points[pos] = Integer.parseInt(inp[pos]);
            }
            Arrays.sort(points);
            int q = Integer.parseInt(buffer.readLine());
            for (int pos = 0; pos < q; pos++) {
                inp = buffer.readLine().split(" ");
                long x = Integer.parseInt(inp[0]), y = Integer.parseInt(inp[1]);
                long temp = x+y-points[0];
                if (temp<0)
                {
                    sb.append("0\n");
                    continue;
                }
                int ans = 0;
                boolean flag = true;
                int lo = 0, hi = n-1;
                while (lo <= hi)
                {
                    int mid = (lo+hi)/2;
                    long val = x+y-points[mid];
                    if (val==0)
                    {
                        flag = false;
                        break;
                    }
                    else if (val < 0)
                        hi = mid-1;
                    else
                    {
                        ans = mid;
                        lo = mid+1;
                    }
                }
                if (flag)
                    sb.append(ans+1);
                else
                    sb.append(-1);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
